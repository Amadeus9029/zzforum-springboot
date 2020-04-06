package com.graduate.zzforum.utils;

import java.util.Date;
import java.util.Map;
import java.util.UUID;

import io.jsonwebtoken.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

/**
 * JwtUtil
 */
@Slf4j
@Configuration
public class JwtUtil{
    private static String key;
    @Value("${jwt.ttl}")
    private static Long ttl;
    private static SignatureAlgorithm alg = SignatureAlgorithm.HS256;

    public static String createToken(String name, Map<String, Object> map) {
        long now = System.currentTimeMillis();
        long exp = now + ttl;
        
        JwtBuilder jwtBuilder 
        = Jwts.builder().setId(UUID.randomUUID().toString())
        .setSubject(name)
        .setIssuedAt(new Date())
        .signWith(alg, key);
        jwtBuilder.setClaims(map).setExpiration(new Date(exp));
        String token = jwtBuilder.compact();
        return token;
    }

    public static Claims parseToken(String token){
        System.out.println(token);
        Claims claims = Jwts.parser().setSigningKey(key).parseClaimsJws(token).getBody();
        return claims;
    }

    public static Boolean validateToken(String token){
        try {
            Jwts.parser().setSigningKey(key).parseClaimsJws(token);
            return true;
        } catch (SecurityException | MalformedJwtException e) {
            log.info("Invalid JWT signature.");
            e.printStackTrace();
        } catch (ExpiredJwtException e) {
            log.info("Expired JWT token.");
            e.printStackTrace();
        } catch (UnsupportedJwtException e) {
            log.info("Unsupported JWT token.");
            e.printStackTrace();
        } catch (IllegalArgumentException e) {
            log.info("JWT token compact of handler are invalid.");
            e.printStackTrace();
        }
        return false;
    }
    @Value("${jwt.key}")
    public void setKey(String key){
        JwtUtil.key = key;
    }
}
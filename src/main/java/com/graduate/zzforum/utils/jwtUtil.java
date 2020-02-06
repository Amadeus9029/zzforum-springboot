package com.graduate.zzforum.utils;

import java.util.Date;
import java.util.Map;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

/**
 * jwtUtil
 */
public class jwtUtil {
    private static String key = "RFgQ06spECDAGqwoKQNDoblvJZH8DLj6";
    private static Long ttl = (long) 3600000;

    public static String createJwt(String id, String name, Map<String, Object> map) {
        long now = System.currentTimeMillis();
        long exp = now + ttl;
        
        JwtBuilder jwtBuilder 
        = Jwts.builder().setId(id)
        .setSubject(name)
        .setIssuedAt(new Date())
        .signWith(SignatureAlgorithm.HS256, key);
        jwtBuilder.setClaims(map).setExpiration(new Date(exp));
        String token = jwtBuilder.compact();
        return token;
    }

    public static Claims parseJwt(String token){
        Claims claims = Jwts.parser().setSigningKey(key).parseClaimsJws(token).getBody();
        return claims;
    }
}
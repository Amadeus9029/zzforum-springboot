package com.graduate.zzforum.security;

import com.alibaba.druid.util.StringUtils;
import com.graduate.zzforum.config.SecurityProperties;
import com.graduate.zzforum.utils.JwtUtil;
import io.jsonwebtoken.Claims;
import io.netty.util.internal.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class JwtAuthenticationFilter extends OncePerRequestFilter {
    private final SecurityProperties securityProperties;
    private final UserDetailsService userDetailsService;

    public JwtAuthenticationFilter(SecurityProperties securityProperties,
    @Qualifier("zzUserDetailsServiceImpl") UserDetailsService userDetailsService) {
        this.securityProperties = securityProperties;
        this.userDetailsService = userDetailsService;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request,
    HttpServletResponse response,
    FilterChain filterChain) throws ServletException, IOException {
        //获取请求头中的token
        String token = request.getHeader(securityProperties.getHeader());
        System.out.println(token);
        System.out.println(request);
        if(!StringUtils.isEmpty(token)){
            Claims claims = JwtUtil.parseToken(token);
            String username = claims.getSubject();
            System.out.println(username);
            if(username!=null && SecurityContextHolder.getContext().getAuthentication() == null && JwtUtil.validateToken(token)){
                UserDetails userDetails = userDetailsService.loadUserByUsername(username);
                UsernamePasswordAuthenticationToken auth =
                        new UsernamePasswordAuthenticationToken(username, null, userDetails.getAuthorities());
                SecurityContextHolder.getContext().setAuthentication(auth);
            }
        }
        filterChain.doFilter(request,response);
    }
}

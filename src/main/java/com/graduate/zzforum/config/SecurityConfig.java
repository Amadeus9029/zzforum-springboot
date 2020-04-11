package com.graduate.zzforum.config;

import com.graduate.zzforum.security.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.BeanIds;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    private final JwtAuthenticationSuccessHandler jwtAuthenticationSuccessHandler;
    private final JwtAuthenticationFailureHandler jwtAuthenticationFailureHandler;
    private final JwtAccessDeniedHandler jwtAccessDeniedHandler;
    private final CustomizeAuthenticationEntryPoint customizeAuthenticationEntryPoint;
    private final JwtAuthenticationFilter jwtAuthenticationFilter;
    private final UserDetailsService userDetailsService;

    public SecurityConfig(JwtAuthenticationSuccessHandler jwtAuthenticationSuccessHandler,
                          JwtAuthenticationFailureHandler jwtAuthenticationFailureHandler,
                          JwtAccessDeniedHandler jwtAccessDeniedHandler,
                          CustomizeAuthenticationEntryPoint customizeAuthenticationEntryPoint,
                          JwtAuthenticationFilter jwtAuthenticationFilter,
                          @Qualifier("zzUserDetailsServiceImpl") UserDetailsService userDetailsService) {
        this.jwtAuthenticationSuccessHandler = jwtAuthenticationSuccessHandler;
        this.jwtAuthenticationFailureHandler = jwtAuthenticationFailureHandler;
        this.jwtAccessDeniedHandler = jwtAccessDeniedHandler;
        this.customizeAuthenticationEntryPoint = customizeAuthenticationEntryPoint;
        this.jwtAuthenticationFilter = jwtAuthenticationFilter;
        this.userDetailsService = userDetailsService;
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
    @Bean(name=BeanIds.AUTHENTICATION_MANAGER)
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable()
            .addFilterBefore(jwtAuthenticationFilter,UsernamePasswordAuthenticationFilter.class)
            .sessionManagement()
            .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                // 防止iframe 造成跨域
                .and()
                .headers()
                .frameOptions()
                .disable()
            .and().authorizeRequests()
            // 静态资源等等
            .antMatchers(
                HttpMethod.GET,
                "/*.html",
                "/**/*.html",
                "/**/*.css",
                "/**/*.js",
                "/webSocket/**"
            ).permitAll()
            // swagger 文档
            .antMatchers("/swagger-ui.html").permitAll()
            .antMatchers("/swagger-resources/**").permitAll()
            .antMatchers("/webjars/**").permitAll()
            .antMatchers("/*/api-docs").permitAll()
            // 文件
            .antMatchers("/avatar/**").permitAll()
            .antMatchers("/file/**").permitAll()
            // 阿里巴巴 druid
            .antMatchers("/druid/**").permitAll()
            // 放行OPTIONS请求
            .antMatchers(HttpMethod.OPTIONS, "/**").permitAll()
            // 自定义匿名访问所有url放行 ： 允许匿名和带权限以及登录用户访问
            .antMatchers("/login","/list","/favicon.ico","/roleList","/permissionList","/menuList").permitAll()
            .anyRequest().authenticated();   // 任何请求,登录后可以访问

//        http.exceptionHandling()
//            .authenticationEntryPoint(customizeAuthenticationEntryPoint)
//            .accessDeniedHandler(jwtAccessDeniedHandler);
//        http.authenticationProvider();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService)
                .passwordEncoder(passwordEncoder());
    }
}

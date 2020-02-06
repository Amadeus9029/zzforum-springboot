package com.graduate.zzforum.config.jwt;



/**
 * SecurityConfig
 */

// public class SecurityConfig extends WebSecurityConfigurerAdapter {
//     @Value("123")
//     private String audience;

//     @Value("${spring.security.oauth2.resourceserver.jwt.issuer-uri}")
//     private String issuer;

//     @Override
//     public void configure(HttpSecurity http) throws Exception {
//         http.authorizeRequests()
//                 .mvcMatchers("/api/public").permitAll()
//                 .mvcMatchers("/api/private").authenticated()
//                 .mvcMatchers("/api/private-scoped").hasAuthority("SCOPE_read:messages")
//                 .and()
//                 .oauth2ResourceServer().jwt();
//     }
//     @Bean
//     JwtDecoder jwtDecoder() {
//         NimbusJwtDecoder jwtDecoder = (NimbusJwtDecoder)
//                 JwtDecoders.fromOidcIssuerLocation(issuer);

//         OAuth2TokenValidator<Jwt> audienceValidator = new AudienceValidator(audience);
//         OAuth2TokenValidator<Jwt> withIssuer = JwtValidators.createDefaultWithIssuer(issuer);
//         OAuth2TokenValidator<Jwt> withAudience = new DelegatingOAuth2TokenValidator<>(withIssuer, audienceValidator);

//         jwtDecoder.setJwtValidator(withAudience);

//         return jwtDecoder;
//     }
// }
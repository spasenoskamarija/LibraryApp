package com.pm.library.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;


import java.util.List;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class SecurityConfig {

    private final CustomUsernamePasswordAuthenticationProvider authenticationProvider;
    private final PasswordEncoder passwordEncoder;

    public SecurityConfig(CustomUsernamePasswordAuthenticationProvider authenticationProvider, PasswordEncoder passwordEncoder) {
        this.authenticationProvider = authenticationProvider;
        this.passwordEncoder = passwordEncoder;
    }

    @Bean
    public CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration corsConfiguration = new CorsConfiguration();
        corsConfiguration.setAllowedOrigins(List.of("http://localhost:3001"));
        corsConfiguration.setAllowedMethods(List.of("GET", "POST", "PUT", "DELETE"));
        corsConfiguration.setAllowedHeaders(List.of("*"));
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", corsConfiguration);
        return source;
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.csrf(AbstractHttpConfigurer::disable)
                .cors(httpSecurityCorsConfigurer -> httpSecurityCorsConfigurer.configurationSource(
                        corsConfigurationSource()));
//                .authorizeHttpRequests(requests -> requests
//                        .requestMatchers("/h2/**").permitAll() // Додавање пристап до H2 конзолата
//                        .requestMatchers("/api/user/login", "/api/user/register").permitAll() // Дозволено за сите
//                        .requestMatchers(HttpMethod.GET, "/api/books", "/api/authors", "/api/countries").permitAll()
//                        .anyRequest().authenticated() // За сите останати барања, корисникот мора да биде најавен
//                )
//                .formLogin((form) -> form.loginProcessingUrl(
//                                "/api/user/login")
//                        .permitAll()
//                        .failureUrl("/api/user/login?error=BadCredentials")
//                        .defaultSuccessUrl(
//                                "/swagger-ui/index.html",
//                                true
//                        ))
//                .logout((logout) -> logout.logoutUrl("/api/user/logout")
//                        .clearAuthentication(true)
//                        .invalidateHttpSession(
//                                true)
//                        .deleteCookies("JSESSIONID")
//                        .logoutSuccessUrl("/api/user/login"))
//                //Без ова, браузерот ќе одбие да го вчита H2 Console поради безбедносни причини (X-Frame-Options: DENY).
//                .headers(headers -> headers
//                        .frameOptions(frameOptions -> frameOptions.disable()) // Овозможи H2 во iFrame
//                )
//                .exceptionHandling((ex) -> ex.accessDeniedPage(
//                        "/access_denied"));
        return http.build();
    }

    @Bean
    public AuthenticationManager authManager(HttpSecurity http) throws Exception {
        AuthenticationManagerBuilder authenticationManagerBuilder = http.getSharedObject(
                AuthenticationManagerBuilder.class);
        authenticationManagerBuilder.authenticationProvider(authenticationProvider);
        return authenticationManagerBuilder.build();
    }
}
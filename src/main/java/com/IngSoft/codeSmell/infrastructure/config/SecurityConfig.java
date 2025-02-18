package com.IngSoft.codeSmell.infrastructure.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .csrf(csrf -> csrf.disable()) // Deshabilita CSRF si usas APIs REST sin formularios
                .cors(Customizer.withDefaults()) // Configura CORS (opcional si ya lo hiciste en otra parte)
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/api/skill/**").permitAll() // Permitir acceso sin autenticación
                        .requestMatchers("/swagger-ui/**", "/v3/api-docs/**").permitAll() // Permitir Swagger
                        .anyRequest().authenticated() // Restringir cualquier otra ruta
                )
                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS)) // Sin estado (útil para JWT)
                .httpBasic(Customizer.withDefaults()); // Configura autenticación básica sin deprecaciones

        return http.build();
    }
}


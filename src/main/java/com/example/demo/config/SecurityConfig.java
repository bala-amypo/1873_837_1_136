package com.example.demo.config;

import com.example.demo.security.JwtFilter;
import com.example.demo.security.JwtUtil;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
public class SecurityConfig {

    @Bean
    public JwtUtil jwtUtil() {
        return new JwtUtil(
                "ChangeThisSecretForProductionButKeepItLongEnough",
                3600000
        );
    }

    @Bean
    public JwtFilter jwtFilter(JwtUtil jwtUtil) {
        return new JwtFilter(jwtUtil);
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http,
                                           JwtFilter jwtFilter) throws Exception {

        http
            // ✅ MUST be disabled for POST login
            .csrf(csrf -> csrf.disable())

            // ✅ Stateless API
            .sessionManagement(session ->
                session.sessionCreationPolicy(SessionCreationPolicy.STATELESS)
            )

            // ✅ AUTH RULES
            .authorizeHttpRequests(auth -> auth
                .requestMatchers(
                    "/auth/**",          // 🔥 LOGIN & REGISTER
                    "/swagger-ui/**",
                    "/v3/api-docs/**",
                    "/status"
                ).permitAll()
                .anyRequest().authenticated()
            )

            // ✅ Disable default login form
            .formLogin(form -> form.disable())
            .httpBasic(basic -> basic.disable());

        // ✅ JWT filter (non-blocking)
        http.addFilterBefore(
                jwtFilter,
                UsernamePasswordAuthenticationFilter.class
        );

        return http.build();
    }
}

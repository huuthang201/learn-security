package com.example.ls.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import com.example.ls.services.JpaUserDetailsService;

@Configuration
public class SecurityConfig {
    private final JpaUserDetailsService userDetailsService;

    public SecurityConfig(JpaUserDetailsService uds) {
        this.userDetailsService = uds;
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    // 2. In-memory users: user01 (ROLE_USER) & admin01 (ROLE_ADMIN)
    // @Bean
    // public UserDetailsService userDetailsService(PasswordEncoder encoder) {
    // var user = User.withUsername("user01")
    // .password(encoder.encode("password01"))
    // .roles("USER")
    // .build();

    // var admin = User.withUsername("admin01")
    // .password(encoder.encode("adminpass"))
    // .roles("ADMIN")
    // .build();

    // return new InMemoryUserDetailsManager(user, admin);
    // }

    // @Bean
    // public SecurityFilterChain securityFilterChain(HttpSecurity http) throws
    // Exception {
    // http
    // .csrf(csrf -> csrf.disable())
    // .authorizeHttpRequests(auth -> auth
    // .requestMatchers("/hello").permitAll()
    // .requestMatchers("/secure").authenticated()
    // .anyRequest().denyAll()
    // )
    // // Bật HTTP Basic Auth
    // .httpBasic(httpBasic -> httpBasic.realmName("Spring Security Demo")
    // );

    // return http.build();
    // }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .csrf(csrf -> csrf.disable())
                .sessionManagement(sm -> sm.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .userDetailsService(userDetailsService)
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/api/hello").permitAll()
                        .requestMatchers("/api/user").hasRole("USER")
                        .requestMatchers("/api/admin").hasRole("ADMIN")
                        .anyRequest().authenticated())
                .httpBasic(httpBasic -> httpBasic.realmName("Spring Security Demo"));

        return http.build();
    }
}
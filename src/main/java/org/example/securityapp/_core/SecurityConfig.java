package org.example.securityapp._core;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public BCryptPasswordEncoder encodePwd() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.csrf(configure -> configure.disable());

        http.formLogin(form -> form
                .loginPage("/login-form")
                .usernameParameter("email")
                .loginProcessingUrl("/login") // username=ssar&password=1234
                .defaultSuccessUrl("/main"));

        http.authorizeHttpRequests(
                authorize -> authorize
                        .requestMatchers("/user/**", "/main").authenticated()
                        .anyRequest().permitAll()
        );

        return http.build();
    }
}

package dev.micfro.weeklyquikclyapp.controller;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;


@Configuration
@EnableWebSecurity
public class SecurityConfiguration {


    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests(authorize -> authorize
//                                .requestMatchers("/login").permitAll()
//                                .requestMatchers("/").permitAll()
//                                .anyRequest().authenticated()

                                // for testing purposes only - to be removed
                                // allow all pages, only secret is protected
                                .requestMatchers(("/secret/**")).authenticated()
                                .anyRequest().permitAll()
                )
                .httpBasic(Customizer.withDefaults())
                .formLogin(Customizer.withDefaults());

        return http.build();
    }
}

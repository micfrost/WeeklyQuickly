package dev.micfro.weeklyquikclyapp.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.stereotype.Controller;

import javax.sql.DataSource;

@Configuration
public class AppSecurity {

    @Bean
    public UserDetailsManager userDetailsManager(DataSource dataSource) {

        JdbcUserDetailsManager userDetailsManager = new JdbcUserDetailsManager(dataSource);

        userDetailsManager.setUsersByUsernameQuery("select username, password, enabled from users where username=?");

        userDetailsManager.setAuthoritiesByUsernameQuery("select username, authority from authorities where username=?");

        return userDetailsManager;
    }


    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        httpSecurity
                .authorizeHttpRequests(config -> config
//                        With Security OFF
                        .anyRequest().permitAll()
//

//                        With Security ON
//                                .requestMatchers("/customer").hasRole("CUSTOMER")
//                                .requestMatchers("/customer/**").hasRole("CUSTOMER")
//
//                                .requestMatchers("/employee/**").hasRole("EMPLOYEE")
//                                .requestMatchers("/employee").hasRole("EMPLOYEE")
//
//                                .requestMatchers("/admin/**").hasRole("ADMIN")
//
//                                .anyRequest().authenticated()
                )

                .formLogin(form -> form
                        .loginPage("/login")
                        .loginProcessingUrl("/authenticate")
                        .permitAll()
                )

                .logout(logout -> logout
                        .permitAll()
                )

                .exceptionHandling(conf -> conf
                        .accessDeniedPage("/log-access-denied")

                );


        return httpSecurity.build();

    }


}

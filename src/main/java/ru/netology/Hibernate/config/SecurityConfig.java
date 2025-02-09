package ru.netology.Hibernate.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        String[] admin = {"/persons/by-city", "/persons/lessThan-age"};
        String[] user = {"/persons/name-surname"};
        httpSecurity.authorizeHttpRequests((request) -> request
                        .requestMatchers("/persons/hello").permitAll()
                        .requestMatchers(admin).hasAuthority("write")
                        .requestMatchers(user).hasAuthority("read")
                        .anyRequest().authenticated())
                .formLogin(Customizer.withDefaults())
                .httpBasic(Customizer.withDefaults());
        return httpSecurity.build();
    }

    @Bean
    public UserDetailsService userDetailsService() {
        User.UserBuilder users = User.withDefaultPasswordEncoder();
        InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
        manager.createUser(users.username("User").password("User").authorities("read").build());
        manager.createUser(users.username("Admin").password("Admin").authorities("write", "read").build());
        return manager;
    }
}

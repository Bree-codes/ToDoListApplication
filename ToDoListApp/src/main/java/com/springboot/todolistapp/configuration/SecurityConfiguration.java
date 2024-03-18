package com.springboot.todolistapp.configuration;

import com.springboot.todolistapp.service.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.stereotype.Component;

@EnableWebSecurity
@Component
public class SecurityConfiguration {

    private final RegistrationService registrationService;
    @Autowired
    public SecurityConfiguration(RegistrationService registrationService) {
        this.registrationService = registrationService;
    }


    @Bean
    public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception{
        return httpSecurity.
                csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests(
                        req -> req.requestMatchers("/api/v1/register/**","/api/v1/login/**")
                                .permitAll()
                                .anyRequest()
                                .authenticated()
                )
                .sessionManagement((session)->session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .userDetailsService(registrationService)
                .build();

    }

}

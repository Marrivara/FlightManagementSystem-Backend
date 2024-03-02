package com.company.organization.backend.config;

import com.company.organization.backend.repositories.users.AirlineCompanyRepository;
import com.company.organization.backend.repositories.users.PassengerRepository;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@RequiredArgsConstructor
public class ApplicationConfig {

    private final AirlineCompanyRepository airlineCompanyRepository;
    private final PassengerRepository passengerRepository;


    @Bean
    public UserDetailsService userDetailsService() {

        return username -> {
            var passenger = passengerRepository.findByEmail(username);
            if (passenger.isPresent()) {
                return passenger.get();
            }
            var airlineCompany = airlineCompanyRepository.findByEmail(username);
            if (airlineCompany.isPresent()) {
                return airlineCompany.get();
            }
            throw new UsernameNotFoundException("User not found");
        };

    }

    @Bean
    public AuthenticationProvider authenticationProvider(){
        DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
        authenticationProvider.setUserDetailsService(userDetailsService());
        authenticationProvider.setPasswordEncoder(passwordEncoder());
        return authenticationProvider;
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}

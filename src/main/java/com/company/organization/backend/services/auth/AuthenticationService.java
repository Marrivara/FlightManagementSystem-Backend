package com.company.organization.backend.services.auth;

import com.company.organization.backend.model.Users.AirlineCompany;
import com.company.organization.backend.model.Users.Passenger;
import com.company.organization.backend.model.enums.Gender;
import com.company.organization.backend.repositories.users.AirlineCompanyRepository;
import com.company.organization.backend.repositories.users.PassengerRepository;
import com.company.organization.backend.requests.authRequests.AuthenticationRequest;
import com.company.organization.backend.response.authResponses.AuthenticationResponse;
import com.company.organization.backend.requests.authRequests.RegisterRequest;
import com.company.organization.backend.model.enums.Role;
import com.company.organization.backend.services.jwt.JwtService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationService {

    private final PassengerRepository passengerRepository;
    private final AirlineCompanyRepository airlineCompanyRepository;

    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    public AuthenticationResponse register(RegisterRequest registerRequest) {
        switch (registerRequest.getAccountType()) {
            case Passenger -> {
                var passenger = Passenger.builder()
                        .tcNo(registerRequest.getTcNo())
                        .firstName(registerRequest.getFirstName())
                        .lastName(registerRequest.getLastName())
                        .gender(Gender.valueOf(registerRequest.getGender()))
                        .age(registerRequest.getAge())
                        .phoneNumber(registerRequest.getPhoneNumber())
                        .passportNumber(registerRequest.getPassportNumber())
                        .email(registerRequest.getEmail())
                        .password(passwordEncoder.encode(registerRequest.getPassword()))
                        .role(Role.USER)
                        .build();
                passengerRepository.save(passenger);
                var jwtToken = jwtService.generateToken(passenger);
                return AuthenticationResponse.builder()
                        .token(jwtToken)
                        .build();
            }
            case AirlineCompany -> {
                var airlineCompany = AirlineCompany.builder()
                        .name(registerRequest.getName())
                        .email(registerRequest.getEmail())
                        .password(passwordEncoder.encode(registerRequest.getPassword()))
                        .role(Role.ADMIN)
                        .build();
                airlineCompanyRepository.save(airlineCompany);
                var jwtToken = jwtService.generateToken(airlineCompany);
                return AuthenticationResponse.builder()
                        .token(jwtToken)
                        .build();
            }
            default -> throw new IllegalStateException("Unexpected value: " + registerRequest.getAccountType());
        }

    }

    public AuthenticationResponse login(AuthenticationRequest authenticationRequest) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        authenticationRequest.getEmail(),
                        authenticationRequest.getPassword()
                )
        );
        UserDetails user;
        try {
            user = passengerRepository.findByEmail(authenticationRequest.getEmail())
                    .orElseThrow(() -> new UsernameNotFoundException("User not found"));
        } catch (UsernameNotFoundException e) {
            user = airlineCompanyRepository.findByEmail(authenticationRequest.getEmail())
                    .orElseThrow(() -> new UsernameNotFoundException("User not found"));
        }

        var jwtToken = jwtService.generateToken(user);
        return AuthenticationResponse.builder()
                .token(jwtToken)
                .build();
    }
}

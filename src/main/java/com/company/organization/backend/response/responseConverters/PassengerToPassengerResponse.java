package com.company.organization.backend.response.responseConverters;

import com.company.organization.backend.model.Users.Passenger;
import com.company.organization.backend.response.entityResponses.CardInfoResponse;
import com.company.organization.backend.response.entityResponses.PassengerResponse;
import org.springframework.stereotype.Component;

@Component
public class PassengerToPassengerResponse {

    public static PassengerResponse convert(Passenger passenger, CardInfoResponse cardInfoResponse) {
        return PassengerResponse.builder()
                .id(passenger.getId())
                .firstName(passenger.getFirstName())
                .lastName(passenger.getLastName())
                .gender(passenger.getGender())
                .email(passenger.getEmail())
                .age(passenger.getAge())
                .phoneNumber(passenger.getPhoneNumber())
                .passportNumber(passenger.getPassportNumber())
                .tcNo(passenger.getTcNo())
                //.roles(passenger.getAuthorities())
                //.tickets(passenger.getTickets())
                .cardInfo(cardInfoResponse)
                //.flights(passenger.getFlights())
                .createdAt(passenger.getCreatedAt())
                .deletedAt(passenger.getDeletedAt())
                .build();
    }
}

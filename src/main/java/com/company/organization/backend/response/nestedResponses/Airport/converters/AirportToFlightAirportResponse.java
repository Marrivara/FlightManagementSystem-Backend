package com.company.organization.backend.response.nestedResponses.Airport.converters;

import com.company.organization.backend.model.Airport;
import com.company.organization.backend.response.nestedResponses.Airport.FlightAirportResponse;
import org.springframework.stereotype.Component;

@Component
public class AirportToFlightAirportResponse {

    public static FlightAirportResponse convert (Airport airport){
        return FlightAirportResponse.builder()
                .id(airport.getId())
                .code(airport.getCode())
                .name(airport.getName())
                .createdAt(airport.getCreatedAt())
                .deletedAt(airport.getDeletedAt())
                .build();
    }
}

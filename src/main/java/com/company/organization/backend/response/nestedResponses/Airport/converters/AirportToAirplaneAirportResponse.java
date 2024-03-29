package com.company.organization.backend.response.nestedResponses.Airport.converters;

import com.company.organization.backend.model.Airport;
import com.company.organization.backend.response.nestedResponses.Airport.AirplaneAirportResponse;
import org.springframework.stereotype.Component;

@Component
public class AirportToAirplaneAirportResponse {

    public static AirplaneAirportResponse convert(Airport airport) {
        return AirplaneAirportResponse.builder()
                .id(airport.getId())
                .code(airport.getCode())
                .name(airport.getName())
                .runways(airport.getRunways())
                .build();
    }
}

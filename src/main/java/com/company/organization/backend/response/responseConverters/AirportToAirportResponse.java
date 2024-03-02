package com.company.organization.backend.response.responseConverters;

import com.company.organization.backend.model.Airport;
import com.company.organization.backend.response.entityResponses.AirplaneResponse;
import com.company.organization.backend.response.entityResponses.AirportResponse;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class AirportToAirportResponse {
    public static AirportResponse convert(Airport airport, List<AirplaneResponse> airplanes) {
        return AirportResponse.builder()
                .id(airport.getId())
                .code(airport.getCode())
                .name(airport.getName())
                .runways(airport.getRunways())
                .airplanes(airplanes)
                .createdAt(airport.getCreatedAt())
                .deletedAt(airport.getDeletedAt())
                .build();
    }
}

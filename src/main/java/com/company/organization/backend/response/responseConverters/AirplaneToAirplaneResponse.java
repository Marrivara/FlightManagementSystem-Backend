package com.company.organization.backend.response.responseConverters;

import com.company.organization.backend.model.Airplane;
import com.company.organization.backend.response.entityResponses.AirplaneResponse;
import com.company.organization.backend.response.nestedResponses.Airport.AirplaneAirportResponse;
import com.company.organization.backend.response.nestedResponses.Airport.converters.AirportToAirplaneAirportResponse;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class AirplaneToAirplaneResponse {

    public static AirplaneResponse convert(Airplane airplane, AirplaneAirportResponse location) {
        return AirplaneResponse.builder()
                .id(airplane.getId())
                .capacity(airplane.getCapacity())
                .airplaneType(airplane.getAirplaneType())
                .location(location)
                .createdAt(airplane.getCreatedAt())
                .deletedAt(airplane.getDeletedAt())
                .build();
    }

    public static List<AirplaneResponse> convertMultipleAirplanes(List<Airplane> airplanes) {
        return airplanes.stream()
                .map(airplane -> convert(airplane,
                        AirportToAirplaneAirportResponse.convert(airplane.getLocation())))
                .toList();
    }
}

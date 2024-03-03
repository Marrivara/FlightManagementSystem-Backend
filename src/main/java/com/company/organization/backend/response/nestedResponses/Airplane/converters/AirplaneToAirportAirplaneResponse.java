package com.company.organization.backend.response.nestedResponses.Airplane.converters;

import com.company.organization.backend.model.Airplane;
import com.company.organization.backend.response.nestedResponses.Airplane.AirportAirplaneResponse;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class AirplaneToAirportAirplaneResponse {
    public static AirportAirplaneResponse convert(Airplane airplane) {
        return AirportAirplaneResponse.builder()
                .id(airplane.getId())
                .airplaneType(airplane.getAirplaneType())
                .capacity(airplane.getCapacity())
                .createdAt(airplane.getCreatedAt())
                .deletedAt(airplane.getDeletedAt())
                .build();
    }

    public static List<AirportAirplaneResponse> convertMultipleAirplanes(List<Airplane> airplanes) {
        return airplanes.stream()
                .map(AirplaneToAirportAirplaneResponse::convert)
                .toList();
    }
}

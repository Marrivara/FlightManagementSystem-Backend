package com.company.organization.backend.response.nestedResponses.converters;

import com.company.organization.backend.model.Airplane;
import com.company.organization.backend.response.entityResponses.AirplaneResponse;
import com.company.organization.backend.response.nestedResponses.AirplaneAirportResponse;
import com.company.organization.backend.response.nestedResponses.AirportAirplaneResponse;
import com.company.organization.backend.response.responseConverters.AirplaneToAirplaneResponse;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class AirplaneToAirportAirplaneResponse {
    public static AirportAirplaneResponse convert(Airplane airplane) {
        return AirportAirplaneResponse.builder()
                .id(airplane.getId())
                .airplaneType(airplane.getAirplaneType())
                .capacity(airplane.getCapacity())
                .build();
    }

    public static List<AirportAirplaneResponse> convertMultipleAirplanes(List<Airplane> airplanes) {
        return airplanes.stream()
                .map(AirplaneToAirportAirplaneResponse::convert)
                .toList();
    }
}

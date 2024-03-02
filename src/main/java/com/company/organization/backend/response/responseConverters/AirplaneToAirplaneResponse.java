package com.company.organization.backend.response.responseConverters;

import com.company.organization.backend.model.Airplane;
import com.company.organization.backend.response.entityResponses.AirplaneResponse;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class AirplaneToAirplaneResponse {

    public static AirplaneResponse convert(Airplane airplane) {
        return AirplaneResponse.builder()
                .id(airplane.getId())
                .capacity(airplane.getCapacity())
                .airplaneType(airplane.getAirplaneType())
                .build();
    }

    public static List<AirplaneResponse> convertMultipleAirplanes(List<Airplane> airplanes) {
        return airplanes.stream()
                .map(AirplaneToAirplaneResponse::convert)
                .toList();
    }
}

package com.company.organization.backend.response.nestedResponses.Airplane.converters;

import com.company.organization.backend.model.Airplane;
import com.company.organization.backend.response.nestedResponses.Airplane.FlightAirplaneResponse;
import org.springframework.stereotype.Component;

@Component
public class AirplaneToFlightAirplaneResponse {

    public static FlightAirplaneResponse convert(Airplane airplane){
        return FlightAirplaneResponse.builder()
                .id(airplane.getId())
                .capacity(airplane.getCapacity())
                .airplaneType(airplane.getAirplaneType())
                .createdAt(airplane.getCreatedAt())
                .deletedAt(airplane.getDeletedAt())
                .build();
    }
}

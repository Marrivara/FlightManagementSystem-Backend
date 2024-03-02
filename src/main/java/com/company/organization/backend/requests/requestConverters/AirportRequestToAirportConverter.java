package com.company.organization.backend.requests.requestConverters;

import com.company.organization.backend.model.Airport;
import com.company.organization.backend.requests.entityRequests.AirportRequest;
import org.springframework.stereotype.Component;

@Component
public class AirportRequestToAirportConverter {

    public static Airport convert(AirportRequest airportRequest) {
        return Airport.builder()
                .code(airportRequest.getCode())
                .name(airportRequest.getName())
                .runways(airportRequest.getRunways())
                .build();
    }
}

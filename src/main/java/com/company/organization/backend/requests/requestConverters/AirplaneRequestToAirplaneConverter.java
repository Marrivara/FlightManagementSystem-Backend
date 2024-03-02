package com.company.organization.backend.requests.requestConverters;

import com.company.organization.backend.model.Airplane;
import com.company.organization.backend.model.Airport;
import com.company.organization.backend.model.Users.AirlineCompany;
import com.company.organization.backend.requests.entityRequests.AirplaneRequest;
import org.springframework.stereotype.Component;

@Component
public class AirplaneRequestToAirplaneConverter {

    public static Airplane convert(AirplaneRequest airplaneRequest, Airport location, AirlineCompany airlineCompany) {
        return Airplane.builder()
                .airplaneType(airplaneRequest.getAirplaneType())
                .capacity(airplaneRequest.getCapacity())
                .location(location)
                .airlineCompany(airlineCompany)
                .build();
    }
}

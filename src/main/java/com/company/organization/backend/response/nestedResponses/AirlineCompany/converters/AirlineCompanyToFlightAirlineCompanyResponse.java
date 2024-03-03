package com.company.organization.backend.response.nestedResponses.AirlineCompany.converters;

import com.company.organization.backend.model.Users.AirlineCompany;
import com.company.organization.backend.response.nestedResponses.AirlineCompany.FlightAirlineCompanyResponse;
import org.springframework.stereotype.Component;

@Component
public class AirlineCompanyToFlightAirlineCompanyResponse {
    public static FlightAirlineCompanyResponse convert(AirlineCompany airlineCompany) {
        return FlightAirlineCompanyResponse.builder()
                .id(airlineCompany.getId())
                .name(airlineCompany.getName())
                .email(airlineCompany.getEmail())
                .createdAt(airlineCompany.getCreatedAt())
                .deletedAt(airlineCompany.getDeletedAt())
                .build();
    }
}

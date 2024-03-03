package com.company.organization.backend.response.nestedResponses.AirlineCompany.converters;

import com.company.organization.backend.model.Users.AirlineCompany;
import com.company.organization.backend.response.entityResponses.AirplaneResponse;
import com.company.organization.backend.response.nestedResponses.AirlineCompany.PilotAirlineCompanyResponse;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class AirlineCompanyToPilotAirlineCompanyResponse {

    public static PilotAirlineCompanyResponse convert(AirlineCompany airlineCompany) {
        return PilotAirlineCompanyResponse.builder()
                .id(airlineCompany.getId())
                .name(airlineCompany.getName())
                .email(airlineCompany.getEmail())
                .createdAt(airlineCompany.getCreatedAt())
                .deletedAt(airlineCompany.getDeletedAt())
                .build();
    }
}

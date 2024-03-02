package com.company.organization.backend.response.responseConverters;

import com.company.organization.backend.model.Airplane;
import com.company.organization.backend.model.Users.AirlineCompany;
import com.company.organization.backend.response.entityResponses.AirlineCompanyResponse;
import com.company.organization.backend.response.entityResponses.AirplaneResponse;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class AirlineCompanyToAirlineCompanyResponse {

    public static AirlineCompanyResponse convert(AirlineCompany airlineCompany, List<AirplaneResponse> airplanes) {
        return AirlineCompanyResponse.builder()
                .id(airlineCompany.getId())
                .name(airlineCompany.getName())
                .email(airlineCompany.getEmail())
                .airplanes(airplanes)
                .createdAt(airlineCompany.getCreatedAt())
                .deletedAt(airlineCompany.getDeletedAt())
                .build();
    }


}

package com.company.organization.backend.response.nestedResponses.AirlineCompany;

import com.company.organization.backend.response.entityResponses.AirplaneResponse;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class FlightAirlineCompanyResponse {
    private Integer id;
    private String name;
    private String email;
    private Date createdAt;
    private Date deletedAt;
}

package com.company.organization.backend.response.entityResponses;

import com.company.organization.backend.model.enums.AirplaneType;
import com.company.organization.backend.response.nestedResponses.Airport.AirplaneAirportResponse;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AirplaneResponse {

    private Integer id;
    private Integer capacity;
    private AirplaneType airplaneType;
    private AirplaneAirportResponse location;
    //private List<FlightResponse> flights;
    //private AirlineCompanyResponse airlineCompany;
    private Date createdAt;
    private Date deletedAt;
}

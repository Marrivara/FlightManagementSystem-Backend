package com.company.organization.backend.response.nestedResponses.Airplane;

import com.company.organization.backend.model.enums.AirplaneType;
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
public class AirportAirplaneResponse {
    private Integer id;
    private Integer capacity;
    private AirplaneType airplaneType;
    //private List<FlightResponse> flights;
    //private AirlineCompanyResponse airlineCompany;
    private Date createdAt;
    private Date deletedAt;

}

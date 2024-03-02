package com.company.organization.backend.response.entityResponses;

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
public class AirlineCompanyResponse {

        private Integer id;
        private String name;
        private String email;
        private List<AirplaneResponse> airplanes;
        //private List<FlightResponse> flights;
        //private List<PilotResponse> pilots;
        private Date createdAt;
        private Date deletedAt;

}

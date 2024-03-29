package com.company.organization.backend.response.entityResponses;

import com.company.organization.backend.response.nestedResponses.Airplane.AirportAirplaneResponse;
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
public class AirportResponse {

            private Integer id;
            private String code;
            private String name;
            private List<String> runways;
            private List<AirportAirplaneResponse> airplanes;
            private Date createdAt;
            private Date deletedAt;
}

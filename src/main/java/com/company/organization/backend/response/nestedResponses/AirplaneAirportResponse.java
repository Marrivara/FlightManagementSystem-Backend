package com.company.organization.backend.response.nestedResponses;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AirplaneAirportResponse {
    private Integer id;
    private String code;
    private String name;
    private List<String> runways;
}

package com.company.organization.backend.requests.entityRequests;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class FlightDetailRequest {

        private Integer flightId;
        private String departureDate;
        private String arrivalDate;
        private String departureRunway;
        private String arrivalRunway;
}

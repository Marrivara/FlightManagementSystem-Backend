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
public class FlightDetailResponse {

            private Integer id;
            private Date departureDate;
            private Date arrivalDate;
            private Integer delay;
            private String departureRunway;
            private String arrivalRunway;
            private List<Boolean> seats;
            private Date createdAt;
            private Date deletedAt;
}

package com.company.organization.backend.requests.entityRequests;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AirportRequest {

        private String code;
        private String name;
        private List<String> runways;
}

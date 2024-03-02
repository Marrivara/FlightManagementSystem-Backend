package com.company.organization.backend.response.entityResponses;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RouteResponse {
    private List<String> waypoints;
    private Integer estimatedTime;
}

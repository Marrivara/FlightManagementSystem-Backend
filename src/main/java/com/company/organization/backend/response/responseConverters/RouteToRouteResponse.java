package com.company.organization.backend.response.responseConverters;

import com.company.organization.backend.model.Route;
import com.company.organization.backend.response.entityResponses.RouteResponse;
import org.springframework.stereotype.Component;

@Component
public class RouteToRouteResponse {

        public static RouteResponse convert(Route route) {
            return RouteResponse.builder()
                    .waypoints(route.getWaypoints())
                    .estimatedTime(route.getEstimatedTime())
                    .build();
        }
}

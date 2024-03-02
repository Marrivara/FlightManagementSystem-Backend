package com.company.organization.backend.requests.requestConverters;

import com.company.organization.backend.model.Route;
import com.company.organization.backend.requests.entityRequests.RouteRequest;
import org.springframework.stereotype.Component;

@Component
public class RouteRequestToRoute {

    public static Route convert(RouteRequest routeRequest) {
        return Route.builder()
                .estimatedTime(routeRequest.getEstimatedTime())
                .waypoints(routeRequest.getWaypoints())
                .build();
    }
}

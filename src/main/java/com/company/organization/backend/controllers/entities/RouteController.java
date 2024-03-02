package com.company.organization.backend.controllers.entities;

import com.company.organization.backend.requests.entityRequests.RouteRequest;
import com.company.organization.backend.response.entityResponses.RouteResponse;
import com.company.organization.backend.services.entities.RouteService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/route")
public class RouteController {

    private final RouteService routeService;

    public RouteController(RouteService routeService) {
        this.routeService = routeService;
    }

    @PostMapping("/create")
    public ResponseEntity<RouteResponse> createRoute(@RequestBody RouteRequest routeRequest) {
        return ResponseEntity.ok(routeService.createRoute(routeRequest));
    }
}

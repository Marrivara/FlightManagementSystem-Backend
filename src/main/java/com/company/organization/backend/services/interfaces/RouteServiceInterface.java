package com.company.organization.backend.services.interfaces;


import com.company.organization.backend.requests.entityRequests.RouteRequest;
import com.company.organization.backend.response.entityResponses.RouteResponse;

public interface RouteServiceInterface {
    RouteResponse createRoute(RouteRequest routeRequest);
}

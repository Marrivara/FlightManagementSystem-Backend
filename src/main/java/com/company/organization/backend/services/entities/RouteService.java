package com.company.organization.backend.services.entities;

import com.company.organization.backend.model.Route;
import com.company.organization.backend.repositories.entities.RouteRepository;
import com.company.organization.backend.requests.entityRequests.RouteRequest;
import com.company.organization.backend.requests.requestConverters.RouteRequestToRoute;
import com.company.organization.backend.response.entityResponses.RouteResponse;
import com.company.organization.backend.response.responseConverters.RouteToRouteResponse;
import com.company.organization.backend.services.interfaces.RouteServiceInterface;
import org.springframework.stereotype.Service;

@Service
public class RouteService implements RouteServiceInterface {

    private final RouteRepository routeRepository;

    public RouteService(RouteRepository routeRepository) {
        this.routeRepository = routeRepository;
    }

    @Override
    public RouteResponse createRoute(RouteRequest routeRequest) {
        Route route = RouteRequestToRoute.convert(routeRequest);
        routeRepository.save(route);
        return RouteToRouteResponse.convert(route);
    }
}

package com.company.organization.backend.services.interfaces;

import com.company.organization.backend.model.Airport;
import com.company.organization.backend.requests.entityRequests.AirportRequest;
import com.company.organization.backend.requests.requestConverters.AirportRequestToAirportConverter;
import com.company.organization.backend.response.entityResponses.AirplaneResponse;
import com.company.organization.backend.response.entityResponses.AirportResponse;
import com.company.organization.backend.response.responseConverters.AirportToAirportResponse;

import java.util.List;

public interface AirportServiceInterface {

    public AirportResponse createAirport(AirportRequest airportRequest);

    public AirportResponse getAirportResponseById(Integer id);

    public Airport getAirportById(Integer id);

    public AirportResponse addAirplaneToAirport(Integer airportId, Integer airplaneId);

    public AirportResponse removeAirplaneFromAirport(Integer airportId, Integer airplaneId);

    public List<AirplaneResponse> getAirplaneResponsesFromAirport(Airport airport);
}

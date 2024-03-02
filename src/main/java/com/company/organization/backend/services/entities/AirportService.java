package com.company.organization.backend.services.entities;

import com.company.organization.backend.model.Airplane;
import com.company.organization.backend.model.Airport;
import com.company.organization.backend.repositories.entities.AirportRepository;
import com.company.organization.backend.requests.requestConverters.AirportRequestToAirportConverter;
import com.company.organization.backend.requests.entityRequests.AirportRequest;
import com.company.organization.backend.response.entityResponses.AirportResponse;
import com.company.organization.backend.response.nestedResponses.AirportAirplaneResponse;
import com.company.organization.backend.response.nestedResponses.converters.AirplaneToAirportAirplaneResponse;
import com.company.organization.backend.response.responseConverters.AirportToAirportResponse;
import com.company.organization.backend.services.interfaces.AirportServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AirportService implements AirportServiceInterface {

    private final AirportRepository airportRepository;
    private final AirplaneService airplaneService;

    @Autowired
    public AirportService(AirportRepository airportRepository, AirplaneService airplaneService) {
        this.airportRepository = airportRepository;
        this.airplaneService = airplaneService;
    }

    @Override
    public AirportResponse createAirport(AirportRequest airportRequest) {
        Airport airport = AirportRequestToAirportConverter.convert(airportRequest);
        airportRepository.save(airport);
        return AirportToAirportResponse.convert(airport, getAirplaneResponsesFromAirport(airport));
    }

    @Override
    public AirportResponse getAirportResponseById(Integer id) {
        Airport airport = getAirportById(id);
        return AirportToAirportResponse.convert(airport, getAirplaneResponsesFromAirport(airport));
    }

    @Override
    public Airport getAirportById(Integer id) {
        return airportRepository.findById(id).orElseThrow( () -> new RuntimeException("Airport not found"));
    }

    @Override
    public AirportResponse addAirplaneToAirport(Integer airportId, Integer airplaneId) {
        Airport airport = getAirportById(airportId);
        Airplane airplane = airplaneService.getAirplaneById(airplaneId);
        airport.getAirplanes().add(airplane);
        return AirportToAirportResponse.convert(airport, getAirplaneResponsesFromAirport(airport));
    }

    @Override
    public AirportResponse removeAirplaneFromAirport(Integer airportId, Integer airplaneId) {
        Airport airport = getAirportById(airportId);
        Airplane airplane = airplaneService.getAirplaneById(airplaneId);
        airport.getAirplanes().remove(airplane);
        return AirportToAirportResponse.convert(airport, getAirplaneResponsesFromAirport(airport));
    }

    @Override
    public List<AirportAirplaneResponse> getAirplaneResponsesFromAirport(Airport airport) {
         return AirplaneToAirportAirplaneResponse.convertMultipleAirplanes(airport.getAirplanes());
    }

}


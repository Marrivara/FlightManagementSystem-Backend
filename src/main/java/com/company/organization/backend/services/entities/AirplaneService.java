package com.company.organization.backend.services.entities;

import com.company.organization.backend.model.Airplane;
import com.company.organization.backend.model.Airport;
import com.company.organization.backend.model.Users.AirlineCompany;
import com.company.organization.backend.repositories.entities.AirplaneRepository;
import com.company.organization.backend.requests.entityRequests.AirplaneRequest;
import com.company.organization.backend.requests.requestConverters.AirplaneRequestToAirplaneConverter;
import com.company.organization.backend.response.entityResponses.AirplaneResponse;
import com.company.organization.backend.response.nestedResponses.Airport.converters.AirportToAirplaneAirportResponse;
import com.company.organization.backend.response.responseConverters.AirplaneToAirplaneResponse;
import com.company.organization.backend.services.interfaces.AirplaneServiceInterface;
import com.company.organization.backend.services.users.AirlineCompanyService;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

@Service
public class AirplaneService implements AirplaneServiceInterface {

    private final AirplaneRepository airplaneRepository;
    private final AirportService airportService;
    private final AirlineCompanyService airlineCompanyService;

    public AirplaneService(AirplaneRepository airplaneRepository, @Lazy AirportService airportService, AirlineCompanyService airlineCompanyService) {
        this.airplaneRepository = airplaneRepository;
        this.airportService = airportService;
        this.airlineCompanyService = airlineCompanyService;
    }

    @Override
    public Airplane getAirplaneById(Integer airplaneId) {
        return airplaneRepository.findById(airplaneId).orElseThrow( () -> new RuntimeException("Airplane not found"));
    }

    @Override
    public AirplaneResponse getAirplaneResponseById(Integer airplaneId) {
        Airplane airplane = getAirplaneById(airplaneId);
        Airport airport = airportService.getAirportById(airplane.getLocation().getId());
        return AirplaneToAirplaneResponse.convert(airplane, AirportToAirplaneAirportResponse.convert(airport));
    }

    @Override
    public AirplaneResponse createAirplane(AirplaneRequest airplaneRequest) {
        Airport airport = airportService.getAirportById(airplaneRequest.getLocationId());
        AirlineCompany airlineCompany = airlineCompanyService.getAirlineCompanyById(airplaneRequest.getAirlineCompanyId());
        Airplane airplane = AirplaneRequestToAirplaneConverter.convert(airplaneRequest, airport, airlineCompany);
        airplaneRepository.save(airplane);
        return AirplaneToAirplaneResponse.convert(airplane, AirportToAirplaneAirportResponse.convert(airport));
    }


}

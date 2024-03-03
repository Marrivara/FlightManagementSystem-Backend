package com.company.organization.backend.services.entities;

import com.company.organization.backend.model.Pilot;
import com.company.organization.backend.model.Users.AirlineCompany;
import com.company.organization.backend.repositories.entities.PilotRepository;
import com.company.organization.backend.requests.entityRequests.PilotRequest;
import com.company.organization.backend.requests.requestConverters.PilotRequestToPilot;
import com.company.organization.backend.response.entityResponses.PilotResponse;
import com.company.organization.backend.response.nestedResponses.AirlineCompany.PilotAirlineCompanyResponse;
import com.company.organization.backend.response.nestedResponses.AirlineCompany.converters.AirlineCompanyToPilotAirlineCompanyResponse;
import com.company.organization.backend.response.nestedResponses.Flight.PilotFlightResponse;
import com.company.organization.backend.response.nestedResponses.Flight.converters.FlightToPilotFlightResponse;
import com.company.organization.backend.response.responseConverters.PilotToPilotResponse;
import com.company.organization.backend.services.interfaces.PilotServiceInterface;
import com.company.organization.backend.services.users.AirlineCompanyService;
import org.slf4j.Logger;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PilotService implements PilotServiceInterface {

    private final PilotRepository pilotRepository;

    private final AirlineCompanyService airlineCompanyService;

    public PilotService(PilotRepository pilotRepository, AirlineCompanyService airlineCompanyService) {
        this.pilotRepository = pilotRepository;
        this.airlineCompanyService = airlineCompanyService;
    }

    Logger logger = org.slf4j.LoggerFactory.getLogger(PilotService.class);
    public PilotResponse createPilot(PilotRequest pilotRequest) {
        logger.info(pilotRequest.toString());
        AirlineCompany airlineCompany = airlineCompanyService.getAirlineCompanyById(pilotRequest.getAirlineCompanyId());
        Pilot pilot = PilotRequestToPilot.convert(pilotRequest, airlineCompany);
        pilotRepository.save(pilot);
        List<PilotFlightResponse> flights = getFlightResponsesFromPilot(pilot);
        PilotAirlineCompanyResponse airlineCompanyResp = AirlineCompanyToPilotAirlineCompanyResponse.convert(airlineCompany);
        return PilotToPilotResponse.convert(pilot, flights, airlineCompanyResp);
    }

    private List<PilotFlightResponse> getFlightResponsesFromPilot(Pilot pilot) {
        return FlightToPilotFlightResponse.convertMultiple(pilot.getFlights());
    }

    public Pilot getPilotById(Integer id) {
        return pilotRepository.findById(id).orElseThrow(() -> new RuntimeException("Pilot not found"));
    }

}

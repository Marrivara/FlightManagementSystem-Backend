package com.company.organization.backend.services.entities;

import com.company.organization.backend.model.Flight;
import com.company.organization.backend.model.FlightDetail;
import com.company.organization.backend.repositories.entities.FlightRepository;
import com.company.organization.backend.services.interfaces.FlightServiceInterface;
import org.springframework.stereotype.Service;

@Service
public class FlightService implements FlightServiceInterface {


    private final FlightRepository flightRepository;
    private final FlightDetailService flightDetailService;

    public FlightService(FlightRepository flightRepository, FlightDetailService flightDetailService) {
        this.flightRepository = flightRepository;
        this.flightDetailService = flightDetailService;
    }

//    @Override
//    public FlightResponse createFlight(FlightRequest flightRequest) {
//        flightRequest.getFlightDetailRequest();
//        FlightDetail flightDetail = flightDetailService.createFlightDetail(flightRequest.getFlightDetailRequest(), flightRequest.getAirplane().getCapacity());
//        Flight newFlight = FlightRequestToFlightConverter.convert(flightRequest, flightDetail);
//        Flight savedFlight = flightRepository.save(newFlight);
//        flightDetailService.setFlight(savedFlight, flightDetail);
//        return FlightToFlightResponseConverter.convert(savedFlight);
//    }
}

package com.company.organization.backend.services.entities;

import com.company.organization.backend.model.Flight;
import com.company.organization.backend.model.FlightDetail;
import com.company.organization.backend.repositories.entities.FlightDetailRepository;
import com.company.organization.backend.requests.entityRequests.FlightDetailRequest;
import com.company.organization.backend.requests.requestConverters.FlightDetailRequestToFlightDetailConverter;
import com.company.organization.backend.response.entityResponses.FlightDetailResponse;
import com.company.organization.backend.response.responseConverters.FlightDetailToFlightDetailResponse;
import com.company.organization.backend.services.interfaces.FlightDetailServiceInterface;
import org.springframework.stereotype.Service;

@Service
public class FlightDetailService implements FlightDetailServiceInterface {

    private final FlightDetailRepository flightDetailRepository;

    public FlightDetailService(FlightDetailRepository flightDetailRepository) {
        this.flightDetailRepository = flightDetailRepository;
    }

    public FlightDetailResponse createFlightDetail(FlightDetailRequest flightDetailRequest, Integer capacity) {
        FlightDetail flightDetail = FlightDetailRequestToFlightDetailConverter.convert(flightDetailRequest, capacity);
        flightDetailRepository.save(flightDetail);
        return FlightDetailToFlightDetailResponse.convert(flightDetail);
    }

    public FlightDetail getFlightDetailById(Integer id){
        return flightDetailRepository.findById(id).orElseThrow(() -> new RuntimeException("Flight detail not found"));
    }

    public FlightDetailResponse getFlightDetailResponseById(Integer id) {
        FlightDetail flightDetail = getFlightDetailById(id);
        return FlightDetailToFlightDetailResponse.convert(flightDetail);
    }

    @Override
    public FlightDetailResponse setFlight(Flight savedFlight, FlightDetail flightDetail) {
        flightDetail.setFlight(savedFlight);
        flightDetailRepository.save(flightDetail);
        return FlightDetailToFlightDetailResponse.convert(flightDetail);
    }
}

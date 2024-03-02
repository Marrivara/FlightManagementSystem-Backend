package com.company.organization.backend.services.interfaces;

import com.company.organization.backend.model.Flight;
import com.company.organization.backend.model.FlightDetail;
import com.company.organization.backend.response.entityResponses.FlightDetailResponse;

public interface FlightDetailServiceInterface {

    FlightDetailResponse setFlight(Flight savedFlight, FlightDetail flightDetail);
}

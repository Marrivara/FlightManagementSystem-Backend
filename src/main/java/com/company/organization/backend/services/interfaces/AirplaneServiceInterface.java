package com.company.organization.backend.services.interfaces;

import com.company.organization.backend.model.Airplane;
import com.company.organization.backend.requests.entityRequests.AirplaneRequest;
import com.company.organization.backend.response.entityResponses.AirplaneResponse;

public interface AirplaneServiceInterface {
    Airplane getAirplaneById(Integer airplaneId);

    AirplaneResponse getAirplaneResponseById(Integer airplaneId);

    AirplaneResponse createAirplane(AirplaneRequest airplaneRequest);
}

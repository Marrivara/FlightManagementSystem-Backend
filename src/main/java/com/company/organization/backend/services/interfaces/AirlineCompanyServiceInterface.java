package com.company.organization.backend.services.interfaces;

import com.company.organization.backend.model.Users.AirlineCompany;
import com.company.organization.backend.response.entityResponses.AirplaneResponse;

import java.util.List;

public interface AirlineCompanyServiceInterface {

    AirlineCompany getAirlineCompanyById(Integer id);

    List<AirplaneResponse> getAirplaneResponsesFromAirlineCompany(AirlineCompany airlineCompany);
}

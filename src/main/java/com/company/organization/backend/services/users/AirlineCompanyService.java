package com.company.organization.backend.services.users;

import com.company.organization.backend.model.Users.AirlineCompany;
import com.company.organization.backend.repositories.users.AirlineCompanyRepository;
import com.company.organization.backend.response.entityResponses.AirlineCompanyResponse;
import com.company.organization.backend.response.entityResponses.AirplaneResponse;
import com.company.organization.backend.response.responseConverters.AirlineCompanyToAirlineCompanyResponse;
import com.company.organization.backend.response.responseConverters.AirplaneToAirplaneResponse;
import com.company.organization.backend.services.interfaces.AirlineCompanyServiceInterface;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AirlineCompanyService implements AirlineCompanyServiceInterface {

    private final AirlineCompanyRepository airlineCompanyRepository;

    public AirlineCompanyService(AirlineCompanyRepository airlineCompanyRepository) {
        this.airlineCompanyRepository = airlineCompanyRepository;
    }

    @Override
    public AirlineCompany getAirlineCompanyById(Integer id) {
        return airlineCompanyRepository.findById(id).orElseThrow( () -> new RuntimeException("Airline Company not found"));
    }

    public AirlineCompanyResponse getAirlineCompanyResponseById(Integer id) {
        AirlineCompany airlineCompany = getAirlineCompanyById(id);
        return AirlineCompanyToAirlineCompanyResponse.convert(airlineCompany, getAirplaneResponsesFromAirlineCompany(airlineCompany));
    }
    @Override
    public List<AirplaneResponse> getAirplaneResponsesFromAirlineCompany(AirlineCompany airlineCompany) {
        return AirplaneToAirplaneResponse.convertMultipleAirplanes(airlineCompany.getAirplanes());
    }
}

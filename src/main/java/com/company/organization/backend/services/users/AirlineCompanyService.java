package com.company.organization.backend.services.users;

import com.company.organization.backend.model.Users.AirlineCompany;
import com.company.organization.backend.repositories.users.AirlineCompanyRepository;
import com.company.organization.backend.services.interfaces.AirlineCompanyServiceInterface;
import org.springframework.stereotype.Service;


@Service
public class AirlineCompanyService implements AirlineCompanyServiceInterface {

    private final AirlineCompanyRepository airlineCompanyRepository;

    public AirlineCompanyService(AirlineCompanyRepository airlineCompanyRepository) {
        this.airlineCompanyRepository = airlineCompanyRepository;
    }

    @Override
    public AirlineCompany getAirlineCompanyById(Integer id) {
        return airlineCompanyRepository.findById(id).orElseThrow(()->new RuntimeException("AirlineCompany not found"));
    }
}

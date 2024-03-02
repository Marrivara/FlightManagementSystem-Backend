package com.company.organization.backend.controllers.users;

import com.company.organization.backend.response.entityResponses.AirlineCompanyResponse;
import com.company.organization.backend.services.users.AirlineCompanyService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/airlineCompany")
public class AirlineCompanyController {

    private final AirlineCompanyService airlineCompanyService;

    public AirlineCompanyController(AirlineCompanyService airlineCompanyService) {
        this.airlineCompanyService = airlineCompanyService;
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<AirlineCompanyResponse> getAirlineCompanyById(@PathVariable Integer id){
        return ResponseEntity.ok(airlineCompanyService.getAirlineCompanyResponseById(id));
    }
}

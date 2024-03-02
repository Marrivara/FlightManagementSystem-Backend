package com.company.organization.backend.controllers.entities;

import com.company.organization.backend.model.Airport;
import com.company.organization.backend.requests.entityRequests.AirportRequest;
import com.company.organization.backend.response.entityResponses.AirportResponse;
import com.company.organization.backend.services.entities.AirportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/airports")
public class AirportController {

    private final AirportService airportService;

    @Autowired
    public AirportController(AirportService airportService) {
        this.airportService = airportService;
    }


    @PostMapping("/create")
    public ResponseEntity<AirportResponse> createAirport(@RequestBody AirportRequest airportRequest) {
        AirportResponse airport = airportService.createAirport(airportRequest);
        return ResponseEntity.ok(airport);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<AirportResponse> getAirportById(@PathVariable Integer id) {
        AirportResponse airport = airportService.getAirportResponseById(id);
        return ResponseEntity.ok(airport);
    }

}

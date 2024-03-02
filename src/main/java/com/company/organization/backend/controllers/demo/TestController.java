package com.company.organization.backend.controllers.demo;

import com.company.organization.backend.model.Airplane;
import com.company.organization.backend.requests.entityRequests.AirplaneRequest;
import com.company.organization.backend.services.entities.AirplaneService;
import com.company.organization.backend.services.entities.AirportService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/test")
public class TestController {

    private final AirplaneService airplaneService;
    private final AirportService airportService;

    public TestController(AirplaneService airplaneService, AirportService airportService) {
        this.airplaneService = airplaneService;
        this.airportService = airportService;
    }

    @GetMapping("/hello")
    public String test() {
        return "Hello World!";
    }

    @GetMapping("/getAirplaneById/{id}")
    public ResponseEntity<Airplane> getAirplaneById(@PathVariable Integer id) {
        return ResponseEntity.ok(airplaneService.getAirplaneById(id));
    }

    @PostMapping("/createAirplane")
    public ResponseEntity<Airplane> createAirplane(@RequestBody AirplaneRequest airplaneRequest) {
        return ResponseEntity.ok(airplaneService.createAirplane(airplaneRequest));
    }

}

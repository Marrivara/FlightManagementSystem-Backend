package com.company.organization.backend.controllers.users;

import com.company.organization.backend.model.Users.Passenger;
import com.company.organization.backend.response.entityResponses.PassengerResponse;
import com.company.organization.backend.services.users.PassengerService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/passenger")
@RequiredArgsConstructor
public class PassengerController {

    private final PassengerService passengerService;

    public Logger logger = org.slf4j.LoggerFactory.getLogger(PassengerController.class);

    @GetMapping
    @RequestMapping("/get/{id}")
    public ResponseEntity<PassengerResponse> getPassengerById(@PathVariable Integer id){
        return ResponseEntity.ok(passengerService.getPassengerResponseById(id));
    }

    @GetMapping
    @RequestMapping("/{id}")
    public ResponseEntity<Passenger> getPassenger(@PathVariable Integer id){
        logger.info("PassengerController getPassenger method called");
        return ResponseEntity.ok(passengerService.getPassengerById(id));
    }
}

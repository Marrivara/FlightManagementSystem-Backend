package com.company.organization.backend.controllers.entities;

import com.company.organization.backend.requests.entityRequests.PilotRequest;
import com.company.organization.backend.response.entityResponses.PilotResponse;
import com.company.organization.backend.services.entities.PilotService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/pilots")
@RequiredArgsConstructor
public class PilotController {

    private final PilotService pilotService;

    @PostMapping("/create")
    public ResponseEntity<PilotResponse> createPilot(@RequestBody PilotRequest pilotRequest) {
        return ResponseEntity.ok(pilotService.createPilot(pilotRequest));
    }


}

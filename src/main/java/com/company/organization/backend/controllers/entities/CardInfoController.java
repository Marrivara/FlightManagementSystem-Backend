package com.company.organization.backend.controllers.entities;

import com.company.organization.backend.model.CardInfo;
import com.company.organization.backend.model.Users.Passenger;
import com.company.organization.backend.requests.entityRequests.CardInfoRequest;
import com.company.organization.backend.response.entityResponses.CardInfoResponse;
import com.company.organization.backend.services.entities.CardInfoService;
import com.company.organization.backend.services.users.PassengerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/passenger/cardInfo")
@RequiredArgsConstructor
public class CardInfoController {

    private final CardInfoService cardInfoService;

    @PostMapping
    @RequestMapping("/create")
    public ResponseEntity<CardInfoResponse> createCardInfo(@RequestBody CardInfoRequest cardInfoRequest){
        return ResponseEntity.ok(cardInfoService.createCardInfo(cardInfoRequest));
    }

    @GetMapping
    @RequestMapping("/get/{id}")
    public ResponseEntity<CardInfoResponse> getCardInfoById(@PathVariable Integer id){
        return ResponseEntity.ok(cardInfoService.getCardInfoResponseById(id));
    }

}

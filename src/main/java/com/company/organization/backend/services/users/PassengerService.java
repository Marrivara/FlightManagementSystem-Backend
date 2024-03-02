package com.company.organization.backend.services.users;

import com.company.organization.backend.model.CardInfo;
import com.company.organization.backend.model.Users.Passenger;
import com.company.organization.backend.repositories.entities.CardInfoRepository;
import com.company.organization.backend.repositories.users.PassengerRepository;
import com.company.organization.backend.response.entityResponses.PassengerResponse;
import com.company.organization.backend.response.responseConverters.CardInfoToCardInfoResponse;
import com.company.organization.backend.response.responseConverters.PassengerToPassengerResponse;
import com.company.organization.backend.services.entities.CardInfoService;
import com.company.organization.backend.services.interfaces.PassengerServiceInterface;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

@Service

public class PassengerService implements PassengerServiceInterface {



    private final PassengerRepository passengerRepository;

    private final CardInfoService cardInfoService;

    private final CardInfoRepository cardInfoRepository;

    @Autowired
    public PassengerService(PassengerRepository passengerRepository,@Lazy CardInfoService cardInfoService, CardInfoRepository cardInfoRepository) {
        this.passengerRepository = passengerRepository;
        this.cardInfoService = cardInfoService;
        this.cardInfoRepository = cardInfoRepository;
    }

    public Passenger getPassengerById(Integer id) {
        return passengerRepository.findById(id).orElseThrow(()->new RuntimeException("Passenger not found"));
    }

    public PassengerResponse getPassengerResponseById(Integer id) {
        Passenger passenger = getPassengerById(id);
        return PassengerToPassengerResponse.convert(passenger, CardInfoToCardInfoResponse.convert(passenger.getCardInfo()));
    }

    public void setCardInfo(Passenger passenger, CardInfo cardInfo) {
        passenger.setCardInfo(cardInfo);
        passengerRepository.save(passenger);
    }

}

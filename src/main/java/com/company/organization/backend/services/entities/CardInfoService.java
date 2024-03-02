package com.company.organization.backend.services.entities;

import com.company.organization.backend.model.CardInfo;
import com.company.organization.backend.model.Users.Passenger;
import com.company.organization.backend.repositories.entities.CardInfoRepository;
import com.company.organization.backend.requests.requestConverters.CardInfoRequestToCardInfoConverter;
import com.company.organization.backend.requests.entityRequests.CardInfoRequest;
import com.company.organization.backend.response.entityResponses.CardInfoResponse;
import com.company.organization.backend.response.responseConverters.CardInfoToCardInfoResponse;
import com.company.organization.backend.services.interfaces.CardInfoServiceInterface;
import com.company.organization.backend.services.users.PassengerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

@Service
public class CardInfoService implements CardInfoServiceInterface {

    private final PassengerService passengerService;
    private final CardInfoRepository cardInfoRepository;

    @Autowired
    public CardInfoService(@Lazy PassengerService passengerService, CardInfoRepository cardInfoRepository) {
        this.passengerService = passengerService;
        this.cardInfoRepository = cardInfoRepository;
    }

    public CardInfoResponse createCardInfo(CardInfoRequest cardInfoRequest) {
        Passenger passenger = passengerService.getPassengerById(cardInfoRequest.getPassengerId());
        CardInfo cardInfo = CardInfoRequestToCardInfoConverter.convert(cardInfoRequest, passenger);
        CardInfo newCard = cardInfoRepository.save(cardInfo);
        try{
            passengerService.setCardInfo(passenger, cardInfo);
        }catch (Exception e){
            cardInfoRepository.delete(newCard);
            throw new RuntimeException("Error while setting card info to passenger");
        }
        return CardInfoToCardInfoResponse.convert(newCard);
    }

    public CardInfo getCardInfoById(Integer id){
        return cardInfoRepository.findById(id).orElseThrow(() -> new RuntimeException("Card info not found"));
    }

    public CardInfoResponse getCardInfoResponseById(Integer id){
        return CardInfoToCardInfoResponse.convert(getCardInfoById(id));
    }

}

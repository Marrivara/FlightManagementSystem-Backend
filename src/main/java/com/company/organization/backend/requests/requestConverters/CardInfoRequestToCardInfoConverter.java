package com.company.organization.backend.requests.requestConverters;

import com.company.organization.backend.model.CardInfo;
import com.company.organization.backend.model.Users.Passenger;
import com.company.organization.backend.requests.entityRequests.CardInfoRequest;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

@Component
public class CardInfoRequestToCardInfoConverter {

    public static CardInfo convert(CardInfoRequest cardInfoRequest, Passenger passenger) {
        //convert string to date
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM");
        Date date;
        try {
            date = dateFormat.parse(cardInfoRequest.getExpirationDate());
        } catch (Exception e) {
            date = new Date();
        }

        return CardInfo.builder()
                .cardNumber(cardInfoRequest.getCardNumber())
                .expirationDate(date)
                .cvv(cardInfoRequest.getCvv())
                .passenger(passenger)
                .build();

    }
}

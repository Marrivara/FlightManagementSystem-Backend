package com.company.organization.backend.response.responseConverters;

import com.company.organization.backend.model.CardInfo;
import com.company.organization.backend.response.entityResponses.CardInfoResponse;
import org.springframework.stereotype.Component;

@Component
public class CardInfoToCardInfoResponse {

    public static CardInfoResponse convert(CardInfo cardInfo) {
        return CardInfoResponse.builder()
                .id(cardInfo.getId())
                .cardNumber(cardInfo.getCardNumber())
                .expirationDate(cardInfo.getExpirationDate())
                .cvv(cardInfo.getCvv())
                .createdAt(cardInfo.getCreatedAt())
                .deletedAt(cardInfo.getDeletedAt())
                .passengerId(cardInfo.getPassenger().getId())
                .build();
    }
}

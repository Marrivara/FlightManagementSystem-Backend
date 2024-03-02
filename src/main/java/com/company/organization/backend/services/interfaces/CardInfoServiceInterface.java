package com.company.organization.backend.services.interfaces;

import com.company.organization.backend.model.CardInfo;
import com.company.organization.backend.requests.entityRequests.CardInfoRequest;
import com.company.organization.backend.response.entityResponses.CardInfoResponse;

public interface CardInfoServiceInterface {

    public CardInfoResponse createCardInfo(CardInfoRequest cardInfoRequest);

    public CardInfo getCardInfoById(Integer id);

    public CardInfoResponse getCardInfoResponseById(Integer id);
}

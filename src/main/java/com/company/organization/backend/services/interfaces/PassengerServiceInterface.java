package com.company.organization.backend.services.interfaces;

import com.company.organization.backend.model.CardInfo;
import com.company.organization.backend.model.Users.Passenger;

public interface PassengerServiceInterface {

    public Passenger getPassengerById(Integer id);

    public void setCardInfo(Passenger passenger, CardInfo cardInfo);
}

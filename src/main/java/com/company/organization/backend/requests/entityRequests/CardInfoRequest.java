package com.company.organization.backend.requests.entityRequests;

import com.company.organization.backend.model.Users.Passenger;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CardInfoRequest {

    private String cardNumber;
    private String expirationDate;
    private String cvv;
    private Integer passengerId;


}

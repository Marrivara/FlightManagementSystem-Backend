package com.company.organization.backend.requests.authRequests;

import com.company.organization.backend.model.enums.AccountType;
import com.company.organization.backend.model.enums.Gender;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RegisterRequest {

    //For Passenger
    private String tcNo;
    private String firstName;
    private String lastName;
    private String gender;
    private Integer age;
    private String phoneNumber;
    private String passportNumber;

    //For AirlineCompany
    private String name;

    //For Auth
    private String email;
    private String password;
    private AccountType accountType;

}

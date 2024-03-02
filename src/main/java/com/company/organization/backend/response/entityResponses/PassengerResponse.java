package com.company.organization.backend.response.entityResponses;

import com.company.organization.backend.model.CardInfo;
import com.company.organization.backend.model.Flight;
import com.company.organization.backend.model.Ticket;
import com.company.organization.backend.model.enums.Gender;
import lombok.*;

import java.util.Date;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class PassengerResponse {

    private Integer id;
    private String firstName;
    private String lastName;
    private Gender gender;
    private String email;
    private Integer age;
    private String phoneNumber;
    private String passportNumber;
    private String tcNo;
    //private List<String> roles;
    //private List<Ticket> tickets;
    private CardInfoResponse cardInfo;
    //private List<Flight> flights;
    private Date createdAt;
    private Date deletedAt;

}

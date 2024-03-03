package com.company.organization.backend.requests.requestConverters;

import com.company.organization.backend.model.Pilot;
import com.company.organization.backend.model.Users.AirlineCompany;
import com.company.organization.backend.requests.entityRequests.PilotRequest;
import org.springframework.stereotype.Component;

@Component
public class PilotRequestToPilot {

    public static Pilot convert (PilotRequest pilotRequest, AirlineCompany airlineCompany) {
        return Pilot.builder()
                .firstName(pilotRequest.getFirstName())
                .lastName(pilotRequest.getLastName())
                .gender(pilotRequest.getGender())
                .email(pilotRequest.getEmail())
                .age(pilotRequest.getAge())
                .phoneNumber(pilotRequest.getPhoneNumber())
                .airplaneLicences(pilotRequest.getAirplaneLicences())
                .role(pilotRequest.getRole())
                .airlineCompany(airlineCompany)
                .build();

    }
}

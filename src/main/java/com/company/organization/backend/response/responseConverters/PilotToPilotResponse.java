package com.company.organization.backend.response.responseConverters;

import com.company.organization.backend.model.Pilot;
import com.company.organization.backend.response.entityResponses.PilotResponse;
import com.company.organization.backend.response.nestedResponses.AirlineCompany.PilotAirlineCompanyResponse;
import com.company.organization.backend.response.nestedResponses.Flight.PilotFlightResponse;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PilotToPilotResponse {

    public static PilotResponse convert(Pilot pilot,
                                        List<PilotFlightResponse> flights,
                                        PilotAirlineCompanyResponse airlineCompany) {
        return PilotResponse.builder()
                .id(pilot.getId())
                .firstName(pilot.getFirstName())
                .lastName(pilot.getLastName())
                .gender(pilot.getGender())
                .age(pilot.getAge())
                .phoneNumber(pilot.getPhoneNumber())
                .flights(flights)
                .airplaneLicences(pilot.getAirplaneLicences())
                .airlineCompany(airlineCompany)
                .build();
    }
}

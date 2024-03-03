package com.company.organization.backend.response.entityResponses;

import com.company.organization.backend.model.enums.AirplaneType;
import com.company.organization.backend.model.enums.Gender;
import com.company.organization.backend.response.nestedResponses.AirlineCompany.PilotAirlineCompanyResponse;
import com.company.organization.backend.response.nestedResponses.Flight.PilotFlightResponse;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PilotResponse {

        private Integer id;
        private String firstName;
        private String lastName;
        private Gender gender;
        private Integer age;
        private String phoneNumber;
        private List<PilotFlightResponse> flights;
        private List<AirplaneType> airplaneLicences;
        private PilotAirlineCompanyResponse airlineCompany;
}

package com.company.organization.backend.response.nestedResponses.Flight;

import com.company.organization.backend.model.enums.FlightStatus;
import com.company.organization.backend.response.nestedResponses.AirlineCompany.FlightAirlineCompanyResponse;
import com.company.organization.backend.response.nestedResponses.Airplane.FlightAirplaneResponse;
import com.company.organization.backend.response.nestedResponses.Airport.FlightAirportResponse;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PilotFlightResponse {

    private Integer id;
    private Integer flightNumber;

    private FlightAirportResponse departureAirport;
    private FlightAirportResponse arrivalAirport;
    private FlightStatus flightStatus;
    private FlightAirplaneResponse airplane;
    private FlightAirlineCompanyResponse airlineCompany;

    private Date createdAt;
    private Date deletedAt;
}

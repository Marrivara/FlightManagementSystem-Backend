package com.company.organization.backend.response.entityResponses;


import com.company.organization.backend.model.enums.FlightStatus;
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
public class FlightResponse {
    private Integer id;
    private Integer flightNumber;

//    private FlightPilotResponse pilot;
//    private FlightPilotResponse copilot;
//    private List<FlightPassengerResponse> passengers;
//    private FlightAirportResponse departureAirport;
//    private FlightAirportResponse arrivalAirport;
//    private FlightStatus flightStatus;
//    private FlightFlightDetailResponse flightDetail;
//    private FlightAirplaneResponse airplane;
//    private Integer ticketPrice;
//    private FlightAirlineCompanyResponse airlineCompany;

    private Date createdAt;
    private Date deletedAt;
}

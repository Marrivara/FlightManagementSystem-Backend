package com.company.organization.backend.response.nestedResponses.Flight.converters;

import com.company.organization.backend.model.Airport;
import com.company.organization.backend.model.Flight;
import com.company.organization.backend.response.nestedResponses.AirlineCompany.FlightAirlineCompanyResponse;
import com.company.organization.backend.response.nestedResponses.AirlineCompany.converters.AirlineCompanyToFlightAirlineCompanyResponse;
import com.company.organization.backend.response.nestedResponses.Airplane.FlightAirplaneResponse;
import com.company.organization.backend.response.nestedResponses.Airplane.converters.AirplaneToFlightAirplaneResponse;
import com.company.organization.backend.response.nestedResponses.Airport.AirplaneAirportResponse;
import com.company.organization.backend.response.nestedResponses.Airport.FlightAirportResponse;
import com.company.organization.backend.response.nestedResponses.Airport.converters.AirportToAirplaneAirportResponse;
import com.company.organization.backend.response.nestedResponses.Airport.converters.AirportToFlightAirportResponse;
import com.company.organization.backend.response.nestedResponses.Flight.PilotFlightResponse;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Component
public class FlightToPilotFlightResponse {

    public static PilotFlightResponse convert(Flight flight,
                                              FlightAirportResponse departureAirport,
                                              FlightAirportResponse arrivalAirport,
                                              FlightAirplaneResponse airplane,
                                              FlightAirlineCompanyResponse airlineCompany) {
        return PilotFlightResponse.builder()
                .id(flight.getId())
                .flightNumber(flight.getFlightNumber())
                .departureAirport(departureAirport)
                .arrivalAirport(arrivalAirport)
                .flightStatus(flight.getFlightStatus())
                .airplane(airplane)
                .airlineCompany(airlineCompany)
                .createdAt(flight.getCreatedAt())
                .deletedAt(flight.getDeletedAt())
                .build();
    }

    public static List<PilotFlightResponse> convertMultiple(List<Flight> flights) {
        return Optional.ofNullable(flights).orElse(Collections.emptyList()).stream()
                .map(flight -> convert(flight,
                        AirportToFlightAirportResponse.convert(flight.getDepartureAirport()),
                        AirportToFlightAirportResponse.convert(flight.getArrivalAirport()),
                        AirplaneToFlightAirplaneResponse.convert(flight.getAirplane()),
                        AirlineCompanyToFlightAirlineCompanyResponse.convert(flight.getAirlineCompany())))
                .toList();
    }
}

package com.company.organization.backend.requests.requestConverters;

import com.company.organization.backend.model.CardInfo;
import com.company.organization.backend.model.Flight;
import com.company.organization.backend.model.FlightDetail;
import com.company.organization.backend.model.Users.Passenger;
import com.company.organization.backend.requests.entityRequests.CardInfoRequest;
import com.company.organization.backend.requests.entityRequests.FlightDetailRequest;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;

@Component
public class FlightDetailRequestToFlightDetailConverter {

    public static FlightDetail convert(FlightDetailRequest flightDetailRequest, Integer capacity) {
        //convert string to date
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date arrivalDate, departureDate;
        try {
            arrivalDate = dateFormat.parse(flightDetailRequest.getArrivalDate());
            departureDate = dateFormat.parse(flightDetailRequest.getDepartureDate());
        } catch (Exception e) {
            arrivalDate = new Date();
            departureDate = new Date();
        }

        //Create an array list of booleans with given size and make it all false as initial
        ArrayList<Boolean> seats = new ArrayList<>(Collections.nCopies(capacity, false));

        return FlightDetail.builder()
                .arrivalDate(arrivalDate)
                .departureDate(departureDate)
                .arrivalRunway(flightDetailRequest.getArrivalRunway())
                .departureRunway(flightDetailRequest.getDepartureRunway())
                .delay(0)
                .seats(seats)
                .build();
    }
}

package com.company.organization.backend.response.responseConverters;

import com.company.organization.backend.model.FlightDetail;
import com.company.organization.backend.response.entityResponses.FlightDetailResponse;
import org.springframework.stereotype.Component;

@Component
public class FlightDetailToFlightDetailResponse {

    public static FlightDetailResponse convert(FlightDetail flightDetail) {
        return FlightDetailResponse.builder()
                .id(flightDetail.getId())
                .departureDate(flightDetail.getDepartureDate())
                .arrivalDate(flightDetail.getArrivalDate())
                .delay(flightDetail.getDelay())
                .departureRunway(flightDetail.getDepartureRunway())
                .arrivalRunway(flightDetail.getArrivalRunway())
                .seats(flightDetail.getSeats())
                .createdAt(flightDetail.getCreatedAt())
                .deletedAt(flightDetail.getDeletedAt())
                .build();
    }



}

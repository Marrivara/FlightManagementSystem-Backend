package com.company.organization.backend.model;


import com.company.organization.backend.model.Users.AirlineCompany;
import com.company.organization.backend.model.Users.Passenger;
import com.company.organization.backend.model.base.BaseModel;
import com.company.organization.backend.model.enums.FlightStatus;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.List;

@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="flights")
public class Flight extends BaseModel {

    private Integer flightNumber;

    @ManyToOne
    @JoinColumn(name = "pilot_id", referencedColumnName = "id", nullable = false)
    private Pilot pilot;

    @ManyToOne
    @JoinColumn(name = "copilot_id", referencedColumnName = "id", nullable = false)
    private Pilot copilot;

    @ManyToMany(mappedBy = "flights")
    private List<Passenger> passengers;

    @ManyToOne
    @JoinColumn(name = "departure_airport_id", referencedColumnName = "id", nullable = false)
    private Airport departureAirport;

    @ManyToOne
    @JoinColumn(name = "arrival_airport_id", referencedColumnName = "id", nullable = false)
    private Airport arrivalAirport;

    @Enumerated
    private FlightStatus flightStatus;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
    @JoinColumn(name = "flight_detail_id", referencedColumnName = "id", nullable = false)
    private FlightDetail flightDetail;

    @ManyToOne
    @JoinColumn(name = "airplane_id", referencedColumnName = "id", nullable = false)
    private Airplane airplane;

    private Integer ticketPrice;

    @ManyToOne
    @JoinColumn(name = "airline_company_id", referencedColumnName = "id", nullable = false)
    private AirlineCompany airlineCompany;







}

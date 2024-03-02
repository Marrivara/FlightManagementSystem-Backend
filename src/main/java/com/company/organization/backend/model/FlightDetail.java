package com.company.organization.backend.model;

import com.company.organization.backend.model.Users.Passenger;
import com.company.organization.backend.model.base.BaseModel;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.Date;
import java.util.List;

@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="flightDetails")
public class FlightDetail extends BaseModel {

    private Date departureDate;
    private Date arrivalDate;
    private Integer delay;
    private String departureRunway;
    private String arrivalRunway;

    @ElementCollection(targetClass = Boolean.class)
    @CollectionTable(name = "seats", joinColumns = @JoinColumn(name = "flight_detail_id"))
    @Column(name = "seat", nullable = false)
    private List<Boolean> seats;

    @OneToOne(mappedBy = "flightDetail")
    @JsonIgnore
    private Flight flight;
}

package com.company.organization.backend.model;

import com.company.organization.backend.model.Users.AirlineCompany;
import com.company.organization.backend.model.base.Human;
import com.company.organization.backend.model.enums.AirplaneType;
import com.company.organization.backend.model.enums.Role;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.List;


@Data
@NoArgsConstructor
@SuperBuilder
@AllArgsConstructor
@Entity
@Table(name="pilots")
public class Pilot extends Human {

    @OneToMany(mappedBy = "pilot")
    private List<Flight> flights;

    @Enumerated(EnumType.STRING)
    private List<AirplaneType> airplaneLicences;

    @Enumerated(EnumType.STRING)
    private Role role;

    @ManyToOne
    @JoinColumn(name = "airline_company_id", referencedColumnName = "id", nullable = false)
    private AirlineCompany airlineCompany;

}

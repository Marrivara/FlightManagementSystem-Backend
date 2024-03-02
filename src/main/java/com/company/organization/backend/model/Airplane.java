package com.company.organization.backend.model;

import com.company.organization.backend.model.Users.AirlineCompany;
import com.company.organization.backend.model.base.BaseModel;
import com.company.organization.backend.model.enums.AirplaneType;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.List;

@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "airplane")
public class Airplane extends BaseModel {

    @Enumerated(EnumType.STRING)
    private AirplaneType airplaneType;

    private Integer capacity;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "location_id", referencedColumnName = "id", nullable = false)
    private Airport location;

    @OneToMany(mappedBy = "airplane", fetch = FetchType.LAZY)
    private List<Flight> flights;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "airline_company_id", referencedColumnName = "id", nullable = true)
    private AirlineCompany airlineCompany;













}

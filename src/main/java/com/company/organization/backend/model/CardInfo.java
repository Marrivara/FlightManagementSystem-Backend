package com.company.organization.backend.model;

import com.company.organization.backend.model.Users.Passenger;
import com.company.organization.backend.model.base.BaseModel;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.Date;

@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "cardInfo")
public class CardInfo extends BaseModel {
    private String cardNumber;
    private Date expirationDate;
    private String cvv;

    @OneToOne(mappedBy = "cardInfo")
    @JsonIgnore
    private Passenger passenger;
}

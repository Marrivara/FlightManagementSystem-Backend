package com.company.organization.backend.model;

import com.company.organization.backend.model.base.BaseModel;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="airports")
public class Airport extends BaseModel {

    private String code;
    private String name;

    @ElementCollection(targetClass = String.class)
    @CollectionTable(name = "runways", joinColumns = @JoinColumn(name = "airport_id"))
    @Column(name = "runway", nullable = false)
    private List<String> runways = new ArrayList<>();

    @OneToMany(mappedBy = "location")
    @JsonIgnore
    private List<Airplane> airplanes;

}

package com.company.organization.backend.model;

import com.company.organization.backend.model.base.BaseModel;
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
@Table(name="routes")
public class Route extends BaseModel {

    @ElementCollection(targetClass = String.class)
    @CollectionTable(name = "waypoints", joinColumns = @JoinColumn(name = "route_id"))
    @Column(name = "waypoint", nullable = false)
    private List<String> waypoints;
    private Integer estimatedTime;

}

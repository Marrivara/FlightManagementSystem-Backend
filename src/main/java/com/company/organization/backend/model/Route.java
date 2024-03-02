package com.company.organization.backend.model;

import com.company.organization.backend.model.base.BaseModel;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
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
    @ElementCollection
    private List<String> waypoints;
    private Integer estimatedTime;
}

package com.company.organization.backend.repositories.entities;

import com.company.organization.backend.model.FlightDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FlightDetailRepository extends JpaRepository<FlightDetail, Integer> {
}

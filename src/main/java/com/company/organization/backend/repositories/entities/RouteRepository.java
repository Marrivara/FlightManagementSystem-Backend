package com.company.organization.backend.repositories.entities;

import com.company.organization.backend.model.Pilot;
import com.company.organization.backend.model.Route;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RouteRepository extends JpaRepository<Route, Integer> {

}

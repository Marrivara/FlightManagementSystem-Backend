package com.company.organization.backend.repositories.entities;

import com.company.organization.backend.model.Pilot;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PilotRepository extends JpaRepository<Pilot, Integer> {

    Optional<Pilot> findByEmail(String email);
}

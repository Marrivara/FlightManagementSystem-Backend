package com.company.organization.backend.repositories.users;

import com.company.organization.backend.model.Users.Passenger;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PassengerRepository extends JpaRepository<Passenger, Integer> {

        Optional<Passenger> findByEmail(String email);
}

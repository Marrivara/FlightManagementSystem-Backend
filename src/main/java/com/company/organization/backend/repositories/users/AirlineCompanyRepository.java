package com.company.organization.backend.repositories.users;

import com.company.organization.backend.model.Users.AirlineCompany;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AirlineCompanyRepository extends JpaRepository<AirlineCompany, Integer> {

    Optional<AirlineCompany> findByEmail(String email);

}

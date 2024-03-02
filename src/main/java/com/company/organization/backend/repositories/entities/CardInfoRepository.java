package com.company.organization.backend.repositories.entities;

import com.company.organization.backend.model.CardInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CardInfoRepository extends JpaRepository<CardInfo, Integer> {

}

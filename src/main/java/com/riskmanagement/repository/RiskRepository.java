package com.riskmanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.riskmanagement.entites.Risks;


public interface RiskRepository extends JpaRepository<Risks, Long> {

}

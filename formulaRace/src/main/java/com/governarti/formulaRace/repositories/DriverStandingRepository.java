package com.governarti.formulaRace.repositories;

import com.governarti.formulaRace.entities.DriverStanding;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DriverStandingRepository extends JpaRepository<DriverStanding, Integer> {
}

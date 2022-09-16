package com.governarti.formulaRace.repositories;

import com.governarti.formulaRace.entities.ConstructorStanding;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConstructorStandingRepository extends JpaRepository<ConstructorStanding, Integer> {
}

package com.governarti.formulaRace.repositories;

import com.governarti.formulaRace.entities.LapTime;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LapTimeRepository extends JpaRepository<LapTime, Integer> {
}

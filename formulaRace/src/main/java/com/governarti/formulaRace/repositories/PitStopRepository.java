package com.governarti.formulaRace.repositories;

import com.governarti.formulaRace.entities.PitStop;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PitStopRepository extends JpaRepository<PitStop, Integer> {
}

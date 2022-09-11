package com.governarti.formulaRace.repositories;

import com.governarti.formulaRace.entities.SprintResult;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SprintResultRepository extends JpaRepository<SprintResult, Integer> {
}

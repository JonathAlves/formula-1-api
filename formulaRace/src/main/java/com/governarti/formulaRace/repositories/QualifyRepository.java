package com.governarti.formulaRace.repositories;

import com.governarti.formulaRace.entities.Qualify;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QualifyRepository extends JpaRepository<Qualify, Integer> {
}

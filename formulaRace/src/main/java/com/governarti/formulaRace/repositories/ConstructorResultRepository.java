package com.governarti.formulaRace.repositories;

import com.governarti.formulaRace.entities.ConstructorResult;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConstructorResultRepository extends JpaRepository<ConstructorResult, Integer> {
}

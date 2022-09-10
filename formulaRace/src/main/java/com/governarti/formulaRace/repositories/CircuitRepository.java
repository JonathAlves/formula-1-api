package com.governarti.formulaRace.repositories;

import com.governarti.formulaRace.entities.Circuit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CircuitRepository extends JpaRepository<Circuit, Integer> {
}

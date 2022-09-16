package com.governarti.formulaRace.repositories;

import com.governarti.formulaRace.entities.Constructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConstructorRepository extends JpaRepository<Constructor, Integer> {
}

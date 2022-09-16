package com.governarti.formulaRace.repositories;

import com.governarti.formulaRace.entities.Driver;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


@Repository
@Transactional
public interface DriverRepository extends JpaRepository<Driver, Integer> {
}

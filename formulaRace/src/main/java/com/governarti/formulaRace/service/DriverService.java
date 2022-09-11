package com.governarti.formulaRace.service;

import com.governarti.formulaRace.config.ChargeDataBase;
import com.governarti.formulaRace.dto.DriverDTO;
import com.governarti.formulaRace.entities.Driver;
import com.governarti.formulaRace.entities.DriverStanding;
import com.governarti.formulaRace.repositories.DriverRepository;
import com.governarti.formulaRace.repositories.DriverStandingRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
public class DriverService {
    private final DriverRepository driverRepository;
    private final DriverStandingRepository driverStandingRepository;
    private List<DriverStanding> driverStandings = driverStandingRepository.findAll();

    public List<Optional<Driver>> getDriversByOneWin(){
        List<Optional<Driver>> drivers = new ArrayList<>();
        for (DriverStanding driverStanding : driverStandings){
            if(driverStanding.getWins() > 0){
                drivers.add(getById(driverStanding.getDriverId()));
            }
        }

        return drivers;
    }

    public Optional<Driver> getById(int id){
        return driverRepository.findById(id);
    }
}

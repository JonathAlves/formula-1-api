package com.governarti.formulaRace.service;

import com.governarti.formulaRace.config.ChargeDataBase;
import com.governarti.formulaRace.entities.Driver;
import com.governarti.formulaRace.entities.DriverStanding;
import com.governarti.formulaRace.model.DriverModel;
import com.governarti.formulaRace.repositories.DriverRepository;
import com.governarti.formulaRace.repositories.DriverStandingRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
public class DriverService {
    private final DriverRepository driverRepository;
    private final DriverStandingRepository driverStandingRepository;


    public List<DriverModel> getDriversByOneWin() throws ParseException {
        List<DriverModel> drivers = new ArrayList<>();

        DriverModel driverModel;

        for (DriverStanding driverStanding : driverStandingRepository.findAll()){
            boolean existsInList = false;
            if(driverStanding.getWins() > 0){
                driverModel = createDriverModel(getById(driverStanding.getDriverId()), driverStanding);

                for (DriverModel dm : drivers){
                    if(dm.getDriverId() == driverModel.getDriverId()){
                        existsInList = true;
                        break;
                    }
                }

                if(!existsInList){
                    drivers.add(driverModel);;
                }
            }
        }
        return drivers;
    }

    public Optional<Driver> getById(int id){
        return driverRepository.findById(id);
    }
    public DriverModel createDriverModel(Optional<Driver> driver, DriverStanding driverStanding) throws ParseException {
        DriverModel driverModel = new DriverModel();
        DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        if(driver.isPresent()){
            driverModel.setDriverId(driver.get().getDriverId());
            driverModel.setGivenName(driver.get().getForename());
            driverModel.setFamilyName(driver.get().getSurname());
            driverModel.setDateOfBirth(LocalDate.parse(driver.get().getDob(), format));
            driverModel.setNationality(driver.get().getNationality());
            driverModel.setWins(getWinsDriver(driverStanding.getDriverId()));
            driverModel.setUrl(driver.get().getUrl());
        }

        return driverModel;
    }

    public int getWinsDriver(int driverId){
        int wins = 0;
        for(DriverStanding driverStanding : ChargeDataBase.driverStandings){
            if(driverStanding.getDriverId() == driverId){
                wins+= driverStanding.getWins();
            }
        }

        return wins;
    }
}

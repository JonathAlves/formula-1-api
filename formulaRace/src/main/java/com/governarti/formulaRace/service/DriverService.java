package com.governarti.formulaRace.service;

import com.governarti.formulaRace.config.ChargeDataBase;
import com.governarti.formulaRace.entities.Driver;
import com.governarti.formulaRace.entities.DriverStanding;
import com.governarti.formulaRace.model.DriverModel;
import com.governarti.formulaRace.repositories.DriverRepository;
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


    public List<DriverModel> getDriversByOneWin(){
        List<DriverModel> drivers = new ArrayList<>();

        DriverModel driverModel;

        for (DriverStanding driverStanding : ChargeDataBase.driverStandings){
            boolean existeNaLista = false;
            if(driverStanding.getWins() > 0){
                driverModel = createDriverModel(getById(driverStanding.getDriverId()), driverStanding);

                for (DriverModel dm : drivers){
                    if(dm.getDriverId() == driverModel.getDriverId()){
                        existeNaLista = true;
                    }
                }

                if(!existeNaLista){
                    drivers.add(driverModel);;
                }
            }
        }
        return drivers;
    }

    public Optional<Driver> getById(int id){
        return driverRepository.findById(id);
    }
    public DriverModel createDriverModel(Optional<Driver> driver, DriverStanding driverStanding){
        DriverModel driverModel = new DriverModel();

        driverModel.setDriverId(driver.get().getDriverId());
        driverModel.setGivenName(driver.get().getForename());
        driverModel.setFamilyName(driver.get().getSurname());
        driverModel.setDateOfBirth(driver.get().getDob());
        driverModel.setNationality(driver.get().getNationality());
        driverModel.setWins(getWinsDriver(driverStanding.getDriverId()));
        driverModel.setUrl(driver.get().getUrl());

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

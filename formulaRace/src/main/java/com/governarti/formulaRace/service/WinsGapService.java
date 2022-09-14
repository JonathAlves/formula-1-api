package com.governarti.formulaRace.service;

import com.governarti.formulaRace.config.ChargeDataBase;
import com.governarti.formulaRace.entities.Driver;
import com.governarti.formulaRace.entities.Race;
import com.governarti.formulaRace.entities.Result;
import com.governarti.formulaRace.model.WinsGapModel;
import com.governarti.formulaRace.repositories.RaceRepository;
import com.governarti.formulaRace.repositories.ResultRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
public class WinsGapService {
    private final RaceRepository raceRepository;
    private final ResultRepository resultRepository;
    private final DriverService driverService;


    public WinsGapModel getWinsGap(){
        List<Result> results = new ArrayList<>();
        List<Driver> winners = new ArrayList<>();

        for (Result result : ChargeDataBase.results){
            if(result.getPosition().equals("1")){
                if(driverService.getById(result.getDriverId()).isPresent()){
                    winners.add(driverService.getById(result.getDriverId()).get());
                }
                results.add(result);
            }
        }

        return createWGModel(winners, results);
    }

    public WinsGapModel createWGModel(List<Driver> winners, List<Result> results){

        List<WinsGapModel> models = new ArrayList<>();
        WinsGapModel maiorGap = null;
        boolean firstLoop = true;

        for(Driver driver : winners){
            List<Integer> years = new ArrayList<>();
            WinsGapModel wgModel = new WinsGapModel();
            boolean existsInList = false;

            wgModel.setDriverId(driver.getDriverId());
            wgModel.setGivenName(driver.getForename());
            wgModel.setFamilyName(driver.getSurname());
            wgModel.setDateOfBirth(driver.getDob());
            wgModel.setNationality(driver.getNationality());

            for(Result rs : results){
                if(rs.getDriverId() == wgModel.getDriverId()){
                    if(getById(rs.getRaceId()).isPresent()){
                        years.add(getById(rs.getRaceId()).get().getYear());
                    }
                }
            }
            wgModel.setFirstWin(Collections.min(years));
            wgModel.setLastWin(Collections.max(years));

            if(firstLoop){
                maiorGap = wgModel;
                firstLoop = false;
            }

            if((wgModel.getLastWin() - wgModel.getFirstWin()) > (maiorGap.getLastWin() - maiorGap.getFirstWin())){
                maiorGap = wgModel;
            }

            for(WinsGapModel model : models){
                if(wgModel.getDriverId() == model.getDriverId()){
                    existsInList = true;
                    break;
                }
            }

            if(!existsInList){
                models.add(wgModel);
            }

        }

        return maiorGap;
    }

    public Optional<Race> getById(int id){
        return raceRepository.findById(id);
    }

}

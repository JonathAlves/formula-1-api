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
        List<Result> winners = new ArrayList<>();

        for (Result result : ChargeDataBase.results){
            if(result.getPosition().equals("1")){
                winners.add(result);
            }
        }
        return createWGModel(winners);
    }

    public WinsGapModel createWGModel(List<Result> results){
        WinsGapModel wgModel = new WinsGapModel();
        List<Integer> years = new ArrayList<>();
        List<WinsGapModel> models = new ArrayList<>();
        WinsGapModel maiorGap = null;

        for(Result result : results){
            Driver driver;
            driver = driverService.getById(result.getDriverId()).get();

            wgModel.setDriverId(result.getDriverId());
            wgModel.setGivenName(driver.getForename());
            wgModel.setFamilyName(driver.getSurname());
            wgModel.setDateOfBirth(driver.getDob());
            wgModel.setNationality(driver.getNationality());

            years.add(getById(result.getRaceId()).get().getYear());

            wgModel.setLastWin(Collections.max(years));
            wgModel.setFirstWin(Collections.min(years));
            wgModel.setGapFromLastWin(wgModel.getLastWin() - wgModel.getFirstWin());

            models.add(wgModel);
        }
        System.out.println("TESTE");

        for(WinsGapModel winsGapModel : models){
            maiorGap = winsGapModel;
            if(winsGapModel.getGapFromLastWin() > maiorGap.getGapFromLastWin()){
                maiorGap = winsGapModel;
            }
        }


        return maiorGap;
    }

    public Optional<Race> getById(int id){
        return raceRepository.findById(id);
    }

}

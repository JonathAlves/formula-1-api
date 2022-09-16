package com.governarti.formulaRace.service;

import com.governarti.formulaRace.entities.Constructor;
import com.governarti.formulaRace.entities.Result;
import com.governarti.formulaRace.model.DriverMoreTeamsModel;
import com.governarti.formulaRace.repositories.ConstructorRepository;
import com.governarti.formulaRace.repositories.ResultRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class DriverMoreTeamsService {

    private final ResultRepository resultRepository;
    private final ConstructorRepository constructorRepository;
    private final DriverService driverService;

    public List<DriverMoreTeamsModel> getDriversMoreTeams(){

        return createDriversMoreTeams(resultRepository.findAll());

    }

    public List<DriverMoreTeamsModel> createDriversMoreTeams(List<Result> results){
        DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        List<DriverMoreTeamsModel> dmtModels = new ArrayList<>();

        for(Result result : results){
            boolean existsInListModel = false;
            boolean existsInListConstructor = false;
            boolean firstLoop = false;
            List<Constructor> constructors = new ArrayList<>();
            Constructor cstr = new Constructor();
            DriverMoreTeamsModel dmtModel = new DriverMoreTeamsModel();

            if(dmtModels.isEmpty()){
                firstLoop = true;
            }

            if(!firstLoop){
                for(DriverMoreTeamsModel dmtm : dmtModels){
                    if(result.getDriverId() == dmtm.getDriverId()){
                        dmtModel = dmtm;
                        existsInListModel = true;
                        break;
                    }
                }
            }

            if(getConstructorById(result.getConstructorId()).isPresent()){
                cstr = getConstructorById(result.getConstructorId()).get();
            }

            if(driverService.getById(result.getDriverId()).isPresent() && !existsInListModel){
                dmtModel.setDriverId(result.getDriverId());
                dmtModel.setGivenName(driverService.getById(result.getDriverId()).get().getForename());
                dmtModel.setFamilyName(driverService.getById(result.getDriverId()).get().getSurname());
                dmtModel.setDateOfBirth(LocalDate.parse(driverService.getById(result.getDriverId()).get().getDob(), format));
                dmtModel.setNationality(driverService.getById(result.getDriverId()).get().getNationality());
                dmtModel.setConstructors(constructors);
            }


            if(firstLoop || !existsInListModel){
                if(dmtModel.getDriverId() != 0){
                    dmtModels.add(dmtModel);
                }
                constructors.add(cstr);
            }

            if(existsInListModel){
                for (Constructor cst : dmtModel.getConstructors()){
                    if(cstr.getConstructorId() == cst.getConstructorId()){
                        existsInListConstructor = true;
                        break;
                    }
                }

                if(!existsInListConstructor){
                    dmtModel.getConstructors().add(cstr);
                }
            }
        }
        Collections.sort(dmtModels);

        List<DriverMoreTeamsModel> orderedList = new ArrayList<>();

        int count = 1;
        for (DriverMoreTeamsModel driver : dmtModels){
            orderedList.add(driver);
            if(count == 10){
                break;
            }
            count++;
        }

        return orderedList;
    }

    public Optional<Constructor> getConstructorById(int id){
        return constructorRepository.findById(id);
    }
}

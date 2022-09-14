package com.governarti.formulaRace.service;

import com.governarti.formulaRace.model.DriverMoreTeamsModel;
import com.governarti.formulaRace.repositories.DriverRepository;
import com.governarti.formulaRace.repositories.ResultRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class DriverMoreTeamsService {

    private final ResultRepository resultRepository;
    private final DriverRepository driverRepository;

    public List<DriverMoreTeamsModel> getDriversMoreTeams(){
        return null;
    }
}

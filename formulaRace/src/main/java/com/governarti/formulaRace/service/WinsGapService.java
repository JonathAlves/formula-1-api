package com.governarti.formulaRace.service;

import com.governarti.formulaRace.config.ChargeDataBase;
import com.governarti.formulaRace.entities.Result;
import com.governarti.formulaRace.model.WinsGapModel;
import com.governarti.formulaRace.repositories.RaceRepository;
import com.governarti.formulaRace.repositories.ResultRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class WinsGapService {
    private final RaceRepository raceRepository;
    private final ResultRepository resultRepository;


    //Continuar daqui
}

package com.governarti.formulaRace.config;

import com.governarti.formulaRace.entities.Circuit;
import com.governarti.formulaRace.entities.Constructor;
import com.governarti.formulaRace.entities.ConstructorResult;
import com.governarti.formulaRace.entities.ConstructorStanding;
import com.governarti.formulaRace.repositories.CircuitRepository;
import com.governarti.formulaRace.repositories.ConstructorRepository;
import com.governarti.formulaRace.repositories.ConstructorResultRepository;
import com.governarti.formulaRace.repositories.ConstructorStandingRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;


@Configuration
public class ChargeDataBase {
    private static final Logger log = LoggerFactory.getLogger(ChargeDataBase.class);
        private List<Circuit> circuits = CsvHelper.csvToCircuit();
        private List<ConstructorResult> constructorResults = CsvHelper.csvToConstructorResult();
        private List<ConstructorStanding> constructorStandings = CsvHelper.csvToConstructorStanding();
        private List<Constructor> constructors = CsvHelper.csvToConstructor();

    @Bean
    CommandLineRunner initDataBase(
            CircuitRepository circuitRepository,
            ConstructorResultRepository constructorResultRepository,
            ConstructorStandingRepository constructorStandingRepository,
            ConstructorRepository constructorRepository
            ){

        return args -> {
            log.info("Carregando base de dados...");
            circuitRepository.saveAll(circuits);
            constructorResultRepository.saveAll(constructorResults);
            constructorStandingRepository.saveAll(constructorStandings);
            constructorRepository.saveAll(constructors);
            log.info("Base carregada");
        };
    }
}

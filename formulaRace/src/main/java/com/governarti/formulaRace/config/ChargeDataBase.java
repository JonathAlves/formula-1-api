package com.governarti.formulaRace.config;

import com.governarti.formulaRace.entities.*;
import com.governarti.formulaRace.repositories.*;
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
        private List<DriverStanding> driverStandings = CsvHelper.csvToDriverStanding();
        private List<Driver> drivers = CsvHelper.csvToDriver();
        private List<LapTime> lapTimes = CsvHelper.csvToLapTime();
        private List<PitStop> pitStops = CsvHelper.csvToPitStop();
        private List<Qualify> qualifies = CsvHelper.csvToQualify();
        private List<Race> races = CsvHelper.csvToRace();
        private List<Result> results = CsvHelper.csvToResult();

    @Bean
    CommandLineRunner initDataBase(
            CircuitRepository circuitRepository,
            ConstructorResultRepository constructorResultRepository,
            ConstructorStandingRepository constructorStandingRepository,
            ConstructorRepository constructorRepository,
            DriverStandingRepository driverStandingRepository,
            DriverRepository driverRepository,
            LapTimeRepository lapTimeRepository,
            PitStopRepository pitStopRepository,
            QualifyRepository qualifyRepository,
            RaceRepository raceRepository,
            ResultRepository resultRepository
            ){

        return args -> {
            try{
                log.info("Carregando base de dados...");
                circuitRepository.saveAll(circuits);
                constructorResultRepository.saveAll(constructorResults);
                constructorStandingRepository.saveAll(constructorStandings);
                constructorRepository.saveAll(constructors);
                driverStandingRepository.saveAll(driverStandings);
                driverRepository.saveAll(drivers);
                lapTimeRepository.saveAll(lapTimes);
                pitStopRepository.saveAll(pitStops);
                qualifyRepository.saveAll(qualifies);
                raceRepository.saveAll(races);
                resultRepository.saveAll(results);
                log.info("Base carregada");
            } catch (Exception e){
                throw new Exception("Ocorreu um erro ao carregar a base: " + e.getMessage());
            }
        };
    }
}

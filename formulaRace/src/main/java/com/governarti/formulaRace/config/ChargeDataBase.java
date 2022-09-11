package com.governarti.formulaRace.config;

import com.governarti.formulaRace.entities.*;
import com.governarti.formulaRace.repositories.*;
import lombok.RequiredArgsConstructor;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.util.List;
import java.util.Optional;


@Configuration
public class ChargeDataBase {
        private static final Logger log = LoggerFactory.getLogger(ChargeDataBase.class);
        private List<Circuit> circuits = CsvHelper.csvToCircuit();
        private List<ConstructorResult> constructorResults = CsvHelper.csvToConstructorResult();
        private List<ConstructorStanding> constructorStandings = CsvHelper.csvToConstructorStanding();
        private List<Constructor> constructors = CsvHelper.csvToConstructor();
        private List<DriverStanding> driverStandingsCSV = CsvHelper.csvToDriverStanding();
        private List<Driver> driversCSV = CsvHelper.csvToDriver();
        private List<LapTime> lapTimes = CsvHelper.csvToLapTime();
        private List<PitStop> pitStops = CsvHelper.csvToPitStop();
        private List<Qualify> qualifies = CsvHelper.csvToQualify();
        private List<Race> races = CsvHelper.csvToRace();
        private List<Result> results = CsvHelper.csvToResult();
        private List<Season> seasons = CsvHelper.csvToSeason();
        private List<SprintResult> sprintResults = CsvHelper.csvToSprintResult();
        private List<Status> statuses = CsvHelper.csvToStatus();


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
            ResultRepository resultRepository,
            SeasonRepository seasonRepository,
            SprintResultRepository sprintResultRepository,
            StatusRepository statusRepository
            ){

        return args -> {
            try{
                log.info("Carregando base de dados...");
                circuitRepository.saveAll(circuits);
                constructorResultRepository.saveAll(constructorResults);
                constructorStandingRepository.saveAll(constructorStandings);
                constructorRepository.saveAll(constructors);
                driverStandingRepository.saveAll(driverStandingsCSV);
                driverRepository.saveAll(driversCSV);
                lapTimeRepository.saveAll(lapTimes);
                pitStopRepository.saveAll(pitStops);
                qualifyRepository.saveAll(qualifies);
                raceRepository.saveAll(races);
                resultRepository.saveAll(results);
                seasonRepository.saveAll(seasons);
                sprintResultRepository.saveAll(sprintResults);
                statusRepository.saveAll(statuses);
                log.info("Base carregada");
            } catch (Exception e){
                throw new Exception("Ocorreu um erro ao carregar a base: " + e.getMessage());
            }
        };
    }
}

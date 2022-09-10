package com.governarti.formulaRace.config;

import com.governarti.formulaRace.entities.Circuit;
import com.governarti.formulaRace.repositories.CircuitRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.ArrayList;
import java.util.List;


@Configuration
public class ChargeDataBase {
    private static final Logger log = LoggerFactory.getLogger(ChargeDataBase.class);
        private List<Circuit> circuits = CsvHelper.csvToCircuit();

    @Bean
    CommandLineRunner initDataBase(CircuitRepository circuitRepository){

        return args -> {
            log.info("Carregando base de dados...");
            circuitRepository.saveAll(circuits);
            log.info("Base carregada");
        };
    }
}

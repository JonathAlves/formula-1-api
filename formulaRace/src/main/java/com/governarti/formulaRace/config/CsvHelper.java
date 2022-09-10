package com.governarti.formulaRace.config;

import com.governarti.formulaRace.entities.Circuit;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class CsvHelper {
    public static List<Circuit> csvToCircuit() {
        try(BufferedReader fileReader = new BufferedReader(new FileReader("src/main/resources/f1db_csv/circuits.csv"));
            CSVParser csvParser = new CSVParser(fileReader, CSVFormat.EXCEL.withHeader())){

            List<Circuit> circuits = new ArrayList<>();

            Iterable<CSVRecord> csvRecords = csvParser.getRecords();

            for(CSVRecord csvRecord : csvRecords){
                Circuit circuit = new Circuit(
                    Integer.parseInt(csvRecord.get("circuitId")),
                    csvRecord.get("circuitRef"),
                    csvRecord.get("name"),
                    csvRecord.get("location"),
                    csvRecord.get("country"),
                    csvRecord.get("lat"),
                    csvRecord.get("lng"),
                    csvRecord.get("alt"),
                    csvRecord.get("url"));

                circuits.add(circuit);
            }

            return circuits;
        } catch (IOException e){
            throw new RuntimeException("falha ao converter arquivo CSV: " + e.getMessage());
        }
    }





}

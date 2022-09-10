package com.governarti.formulaRace.config;

import com.governarti.formulaRace.entities.*;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

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

    public static List<ConstructorResult> csvToConstructorResult() {
        try(BufferedReader fileReader = new BufferedReader(new FileReader("src/main/resources/f1db_csv/constructor_results.csv"));
            CSVParser csvParser = new CSVParser(fileReader, CSVFormat.EXCEL.withHeader())){

            List<ConstructorResult> constructorResults = new ArrayList<>();

            Iterable<CSVRecord> csvRecords = csvParser.getRecords();

            for(CSVRecord csvRecord : csvRecords){
                ConstructorResult constructorResult = new ConstructorResult(
                        Integer.parseInt(csvRecord.get("constructorResultsId")),
                        Integer.parseInt(csvRecord.get("raceId")),
                        Integer.parseInt(csvRecord.get("constructorId")),
                        Double.parseDouble(csvRecord.get("points")),
                        csvRecord.get("status"));

                constructorResults.add(constructorResult);
            }

            return constructorResults;
        } catch (IOException e){
            throw new RuntimeException("falha ao converter arquivo CSV: " + e.getMessage());
        }
    }

    public static List<ConstructorStanding> csvToConstructorStanding() {
        try(BufferedReader fileReader = new BufferedReader(new FileReader("src/main/resources/f1db_csv/constructor_standings.csv"));
            CSVParser csvParser = new CSVParser(fileReader, CSVFormat.EXCEL.withHeader())){

            List<ConstructorStanding> constructorStandings = new ArrayList<>();

            Iterable<CSVRecord> csvRecords = csvParser.getRecords();

            for(CSVRecord csvRecord : csvRecords){
                ConstructorStanding constructorStanding = new ConstructorStanding(
                        Integer.parseInt(csvRecord.get("constructorStandingsId")),
                        Integer.parseInt(csvRecord.get("raceId")),
                        Integer.parseInt(csvRecord.get("constructorId")),
                        Double.parseDouble(csvRecord.get("points")),
                        Integer.parseInt(csvRecord.get("position")),
                        csvRecord.get("positionText"),
                        Integer.parseInt(csvRecord.get("wins")));

                constructorStandings.add(constructorStanding);
            }

            return constructorStandings;
        } catch (IOException e){
            throw new RuntimeException("falha ao converter arquivo CSV: " + e.getMessage());
        }
    }

    public static List<Constructor> csvToConstructor(){
        try(BufferedReader fileReader = new BufferedReader(new FileReader("src/main/resources/f1db_csv/constructors.csv"));
        CSVParser csvParser = new CSVParser(fileReader, CSVFormat.EXCEL.withHeader())){
            List<Constructor> constructors = new ArrayList<>();

            Iterable<CSVRecord> csvRecords = csvParser.getRecords();

            for(CSVRecord csvRecord : csvRecords){
                Constructor constructor = new Constructor(
                    Integer.parseInt(csvRecord.get("constructorId")),
                    csvRecord.get("constructorRef"),
                    csvRecord.get("name"),
                    csvRecord.get("nationality"),
                    csvRecord.get("url"));

                constructors.add(constructor);
            }
            return constructors;
        } catch (IOException e){
            throw new RuntimeException("falha ao converter arquivo CSV: " + e.getMessage());
        }
    }

    public static List<DriverStanding> csvToDriveStanding(){
        try(BufferedReader fileReader = new BufferedReader(new FileReader("src/main/resources/f1db_csv/driver_standings.csv"));
            CSVParser csvParser = new CSVParser(fileReader, CSVFormat.EXCEL.withHeader())){
            List<DriverStanding> driverStandings = new ArrayList<>();

            Iterable<CSVRecord> csvRecords = csvParser.getRecords();

            for(CSVRecord csvRecord : csvRecords){
                DriverStanding driverStanding = new DriverStanding(
                        Integer.parseInt(csvRecord.get("driverStandingsId")),
                        Integer.parseInt(csvRecord.get("raceId")),
                        Integer.parseInt(csvRecord.get("driverId")),
                        Double.parseDouble(csvRecord.get("points")),
                        Integer.parseInt(csvRecord.get("position")),
                        csvRecord.get("positionText"),
                        Integer.parseInt(csvRecord.get("wins")));

                driverStandings.add(driverStanding);
            }
            return driverStandings;
        } catch (IOException e){
            throw new RuntimeException("falha ao converter arquivo CSV: " + e.getMessage());
        }
    }

}

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

    public static List<DriverStanding> csvToDriverStanding(){
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

    public static List<Driver> csvToDriver(){
        try(BufferedReader fileReader = new BufferedReader(new FileReader("src/main/resources/f1db_csv/drivers.csv"));
            CSVParser csvParser = new CSVParser(fileReader, CSVFormat.EXCEL.withHeader())){
            List<Driver> drivers = new ArrayList<>();

            Iterable<CSVRecord> csvRecords = csvParser.getRecords();

            for(CSVRecord csvRecord : csvRecords){
                Driver driver = new Driver(
                        Integer.parseInt(csvRecord.get("driverId")),
                        csvRecord.get("driverRef"),
                        csvRecord.get("number"),
                        csvRecord.get("code"),
                        csvRecord.get("forename"),
                        csvRecord.get("surname"),
                        csvRecord.get("dob"),
                        csvRecord.get("nationality"),
                        csvRecord.get("url"));
                drivers.add(driver);
            }
            return drivers;
        } catch (IOException e){
            throw new RuntimeException("falha ao converter arquivo CSV: " + e.getMessage());
        }
    }

    public static List<LapTime> csvToLapTime(){
        try(BufferedReader fileReader = new BufferedReader(new FileReader("src/main/resources/f1db_csv/lap_times.csv"));
            CSVParser csvParser = new CSVParser(fileReader, CSVFormat.EXCEL.withHeader())){
            List<LapTime> lapTimes = new ArrayList<>();

            Iterable<CSVRecord> csvRecords = csvParser.getRecords();

            for(CSVRecord csvRecord : csvRecords){
                LapTime lapTime = new LapTime(
                        Integer.parseInt(csvRecord.get("raceId")),
                        Integer.parseInt(csvRecord.get("driverId")),
                        Integer.parseInt(csvRecord.get("lap")),
                        Integer.parseInt(csvRecord.get("position")),
                        csvRecord.get("time"),
                        Long.parseLong(csvRecord.get("milliseconds")));
                lapTimes.add(lapTime);
            }
            return lapTimes;
        } catch (IOException e){
            throw new RuntimeException("falha ao converter arquivo CSV: " + e.getMessage());
        }
    }

    public static List<PitStop> csvToPitStop(){
        try(BufferedReader fileReader = new BufferedReader(new FileReader("src/main/resources/f1db_csv/pit_stops.csv"));
            CSVParser csvParser = new CSVParser(fileReader, CSVFormat.EXCEL.withHeader())){
            List<PitStop> pitStops = new ArrayList<>();

            Iterable<CSVRecord> csvRecords = csvParser.getRecords();

            for(CSVRecord csvRecord : csvRecords){
                PitStop pitStop = new PitStop(
                        Integer.parseInt(csvRecord.get("raceId")),
                        Integer.parseInt(csvRecord.get("driverId")),
                        Integer.parseInt(csvRecord.get("stop")),
                        Integer.parseInt(csvRecord.get("lap")),
                        csvRecord.get("time"),
                        csvRecord.get("duration"),
                        Long.parseLong(csvRecord.get("milliseconds")));
                pitStops.add(pitStop);
            }
            return pitStops;
        } catch (IOException e){
            throw new RuntimeException("falha ao converter arquivo CSV: " + e.getMessage());
        }
    }

    public static List<Qualify> csvToQualify(){
        try(BufferedReader fileReader = new BufferedReader(new FileReader("src/main/resources/f1db_csv/qualifying.csv"));
            CSVParser csvParser = new CSVParser(fileReader, CSVFormat.EXCEL.withHeader())){
            List<Qualify> qualifies = new ArrayList<>();

            Iterable<CSVRecord> csvRecords = csvParser.getRecords();

            for(CSVRecord csvRecord : csvRecords){
                Qualify qualify = new Qualify(
                        Integer.parseInt(csvRecord.get("qualifyId")),
                        Integer.parseInt(csvRecord.get("raceId")),
                        Integer.parseInt(csvRecord.get("driverId")),
                        Integer.parseInt(csvRecord.get("constructorId")),
                        csvRecord.get("number"),
                        Integer.parseInt(csvRecord.get("position")),
                        csvRecord.get("q1"),
                        csvRecord.get("q2"),
                        csvRecord.get("q3"));
                qualifies.add(qualify);
            }
            return qualifies;
        } catch (IOException e){
            throw new RuntimeException("falha ao converter arquivo CSV: " + e.getMessage());
        }
    }

    public static List<Race> csvToRace(){
        try(BufferedReader fileReader = new BufferedReader(new FileReader("src/main/resources/f1db_csv/races.csv"));
            CSVParser csvParser = new CSVParser(fileReader, CSVFormat.EXCEL.withHeader())){
            List<Race> races = new ArrayList<>();

            Iterable<CSVRecord> csvRecords = csvParser.getRecords();

            for(CSVRecord csvRecord : csvRecords){
                Race race = new Race(
                        Integer.parseInt(csvRecord.get("raceId")),
                        Integer.parseInt(csvRecord.get("year")),
                        Integer.parseInt(csvRecord.get("round")),
                        Integer.parseInt(csvRecord.get("circuitId")),
                        csvRecord.get("name"),
                        csvRecord.get("date"),
                        csvRecord.get("time"),
                        csvRecord.get("url"),
                        csvRecord.get("fp1_date"),
                        csvRecord.get("fp1_time"),
                        csvRecord.get("fp2_date"),
                        csvRecord.get("fp2_time"),
                        csvRecord.get("fp3_date"),
                        csvRecord.get("fp3_time"),
                        csvRecord.get("quali_date"),
                        csvRecord.get("quali_time"),
                        csvRecord.get("sprint_date"),
                        csvRecord.get("sprint_time"));
                races.add(race);
            }
            return races;
        } catch (IOException e){
            throw new RuntimeException("falha ao converter arquivo CSV: " + e.getMessage());
        }
    }

    public static List<Result> csvToResult(){
        try(BufferedReader fileReader = new BufferedReader(new FileReader("src/main/resources/f1db_csv/results.csv"));
            CSVParser csvParser = new CSVParser(fileReader, CSVFormat.EXCEL.withHeader())){
            List<Result> results = new ArrayList<>();

            Iterable<CSVRecord> csvRecords = csvParser.getRecords();

            for(CSVRecord csvRecord : csvRecords){
                Result result = new Result(
                        Integer.parseInt(csvRecord.get("resultId")),
                        Integer.parseInt(csvRecord.get("raceId")),
                        Integer.parseInt(csvRecord.get("driverId")),
                        Integer.parseInt(csvRecord.get("constructorId")),
                        csvRecord.get("number"),
                        Integer.parseInt(csvRecord.get("grid")),
                        csvRecord.get("position"),
                        csvRecord.get("positionText"),
                        csvRecord.get("positionOrder"),
                        Double.parseDouble(csvRecord.get("points")),
                        Integer.parseInt(csvRecord.get("laps")),
                        csvRecord.get("time"),
                        csvRecord.get("milliseconds"),
                        csvRecord.get("fastestLap"),
                        csvRecord.get("rank"),
                        csvRecord.get("fastestLapTime"),
                        csvRecord.get("fastestLapSpeed"),
                        Integer.parseInt(csvRecord.get("statusId")));
                results.add(result);
            }
            return results;
        } catch (IOException e){
            throw new RuntimeException("falha ao converter arquivo CSV: " + e.getMessage());
        }
    }

}

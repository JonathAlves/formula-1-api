package com.governarti.formulaRace.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "sprint_results")
@Getter
@Setter
public class SprintResult {

    public SprintResult() {}

    public SprintResult(int resultId, int raceId, int driverId, int constructorId, String number, int grid, String position, String positionText, String positionOrder, double points, int laps, String time, String milliseconds, String fastestLap, String fastestLapTime, int statusId) {
        this.resultId = resultId;
        this.raceId = raceId;
        this.driverId = driverId;
        this.constructorId = constructorId;
        this.number = number;
        this.grid = grid;
        this.position = position;
        this.positionText = positionText;
        this.positionOrder = positionOrder;
        this.points = points;
        this.laps = laps;
        this.time = time;
        this.milliseconds = milliseconds;
        this.fastestLap = fastestLap;
        this.fastestLapTime = fastestLapTime;
        this.statusId = statusId;
    }

    public SprintResult(int id, int resultId, int raceId, int driverId, int constructorId, String number, int grid, String position, String positionText, String positionOrder, double points, int laps, String time, String milliseconds, String fastestLap, String fastestLapTime, int statusId) {
        this.id = id;
        this.resultId = resultId;
        this.raceId = raceId;
        this.driverId = driverId;
        this.constructorId = constructorId;
        this.number = number;
        this.grid = grid;
        this.position = position;
        this.positionText = positionText;
        this.positionOrder = positionOrder;
        this.points = points;
        this.laps = laps;
        this.time = time;
        this.milliseconds = milliseconds;
        this.fastestLap = fastestLap;
        this.fastestLapTime = fastestLapTime;
        this.statusId = statusId;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "RESULT_ID")
    private int resultId;
    @Column(name = "RACE_ID")
    private int raceId;
    @Column(name = "DRIVER_ID")
    private int driverId;
    @Column(name = "CONSTRUCTOR_ID")
    private int constructorId;
    @Column(name = "NUMBER")
    private String number;
    @Column(name = "GRID")
    private int grid;
    @Column(name = "POSITION")
    private String position;
    @Column(name = "POSITION_TEXT")
    private String positionText;
    @Column(name = "POSITION_ORDER")
    private String positionOrder;
    @Column(name = "POINTS")
    private double points;
    @Column(name = "LAPS")
    private int laps;
    @Column(name = "TIME")
    private String time;
    @Column(name = "MILLISECONDS")
    private String milliseconds;
    @Column(name = "FASTEST_LAP")
    private String fastestLap;
    @Column(name = "FASTEST_LAP_TIME")
    private String fastestLapTime;
    @Column(name = "STATUS_ID")
    private int statusId;
}

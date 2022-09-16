package com.governarti.formulaRace.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "results")
@Getter
@Setter
public class Result {

    public Result() {}

    public Result(int resultId, int raceId, int driverId, int constructorId, String number, int grid, String position, String positionText, String positionOrder, double points, int laps, String time, String milliseconds, String fastestLap, String rank, String fastestLapTime, String fastestLapSpeed, int statusId) {
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
        this.rank = rank;
        this.fastestLapTime = fastestLapTime;
        this.fastestLapSpeed = fastestLapSpeed;
        this.statusId = statusId;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "RESULT_ID", nullable = false)
    private int resultId;
    @Column(name = "RACE_ID", nullable = false)
    private int raceId;
    @Column(name = "DRIVER_ID", nullable = false)
    private int driverId;
    @Column(name = "CONSTRUCTOR_ID", nullable = false)
    private int constructorId;
    @Column(name = "NUMBER", nullable = false)
    private String number;
    @Column(name = "GRID", nullable = false)
    private int grid;
    @Column(name = "POSITION")
    private String position;
    @Column(name = "POSITION_TEXT")
    private String positionText;
    @Column(name = "POSITION_ORDER")
    private String positionOrder;
    @Column(name = "POINTS")
    private double points;
    @Column(name = "LAPS", nullable = false)
    private int laps;
    @Column(name = "TIME")
    private String time;
    @Column(name = "MILLISECONDS")
    private String milliseconds;
    @Column(name = "FASTEST_LAP")
    private String fastestLap;
    @Column(name = "RANK")
    private String rank;
    @Column(name = "FASTEST_LAP_TIME")
    private String fastestLapTime;
    @Column(name = "FASTEST_LAP_SPEED")
    private String fastestLapSpeed;
    @Column(name = "STATUS_ID", nullable = false)
    private int statusId;

}

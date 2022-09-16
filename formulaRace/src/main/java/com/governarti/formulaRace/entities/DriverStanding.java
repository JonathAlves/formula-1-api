package com.governarti.formulaRace.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "driver_standings")
@Getter
@Setter
public class DriverStanding {

    public DriverStanding(){}

    public DriverStanding(int driverStandingsId, int raceId, int driverId, double points, int position, String positionText, int wins) {
        this.driverStandingsId = driverStandingsId;
        this.raceId = raceId;
        this.driverId = driverId;
        this.points = points;
        this.position = position;
        this.positionText = positionText;
        this.wins = wins;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "DRIVER_STANDINGS_ID", nullable = false)
    private int driverStandingsId;
    @Column(name = "RACE_ID", nullable = false)
    private int raceId;
    @Column(name = "DRIVER_ID", nullable = false)
    private int driverId;
    @Column(name = "POINTS", nullable = false)
    private double points;
    @Column(name = "POSITION", nullable = false)
    private int position;
    @Column(name = "POSITION_TEXT", nullable = false)
    private String positionText;
    @Column(name = "WINS", nullable = false)
    private int wins;
}

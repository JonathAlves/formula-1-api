package com.governarti.formulaRace.entities;

import lombok.Getter;
import lombok.Setter;

import javax.naming.spi.NamingManager;
import javax.persistence.*;
import java.time.LocalTime;

@Entity
@Table(name = "lap_times")
@Getter
@Setter
public class LapTime {

    public LapTime() {}

    public LapTime(int raceId, int driverId, int lap, int position, String time, long miliseconds) {
        this.raceId = raceId;
        this.driverId = driverId;
        this.lap = lap;
        this.position = position;
        this.time = time;
        this.milliseconds = miliseconds;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "RACE_ID", nullable = false)
    private int raceId;
    @Column(name = "DRIVER_ID", nullable = false)
    private int driverId;
    @Column(name = "LAP", nullable = false)
    private int lap;
    @Column(name = "POSITION", nullable = false)
    private int position;
    @Column(name = "TIME", nullable = false)
    private String time;
    @Column(name = "MILISECONDS", nullable = false)
    private long milliseconds;
}

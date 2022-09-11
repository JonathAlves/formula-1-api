package com.governarti.formulaRace.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "pit_stops")
@Getter
@Setter
public class PitStop {

    public PitStop() {}

    public PitStop(int raceId, int driverId, int stop, int lap, String time, String duration, long milliseconds) {
        this.raceId = raceId;
        this.driverId = driverId;
        this.stop = stop;
        this.lap = lap;
        this.time = time;
        this.duration = duration;
        this.milliseconds = milliseconds;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "RACE_ID", nullable = false)
    private int raceId;
    @Column(name = "DRIVER_ID", nullable = false)
    private int driverId;
    @Column(name = "STOP", nullable = false)
    private int stop;
    @Column(name = "LAP", nullable = false)
    private int lap;
    @Column(name = "TIME", nullable = false)
    private String time;
    @Column(name = "DURATION", nullable = false)
    private String duration;
    @Column(name = "MILLISECONDS", nullable = false)
    private long milliseconds;

}

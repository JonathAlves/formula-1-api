package com.governarti.formulaRace.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "races")
@Getter
@Setter
public class Race {

    public Race() {}

    public Race(int raceId, int year, int round, int circuitId, String name, String date, String time, String url, String fp1_date, String fp1_time, String fp2_date, String fp2_time, String fp3_date, String fp3_time, String quali_date, String quali_time, String sprint_date, String sprint_time) {
        this.raceId = raceId;
        this.year = year;
        this.round = round;
        this.circuitId = circuitId;
        this.name = name;
        this.date = date;
        this.time = time;
        this.url = url;
        this.fp1_date = fp1_date;
        this.fp1_time = fp1_time;
        this.fp2_date = fp2_date;
        this.fp2_time = fp2_time;
        this.fp3_date = fp3_date;
        this.fp3_time = fp3_time;
        this.quali_date = quali_date;
        this.quali_time = quali_time;
        this.sprint_date = sprint_date;
        this.sprint_time = sprint_time;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "RACE_ID", nullable = false)
    private int raceId;
    @Column(name = "YEAR_", nullable = false)
    private int year;
    @Column(name = "ROUND", nullable = false)
    private int round;
    @Column(name = "CIRCUIT_ID")
    private int circuitId;
    @Column(name = "NAME", nullable = false)
    private String name;
    @Column(name = "DATE", nullable = false)
    private String date;
    @Column(name = "TIME", nullable = false)
    private String time;
    @Column(name = "URL", nullable = false)
    private String url;
    @Column(name = "FP1_DATE")
    private String fp1_date;
    @Column(name = "FP1_TIME")
    private String fp1_time;
    @Column(name = "FP2_DATE")
    private String fp2_date;
    @Column(name = "FP2_TIME")
    private String fp2_time;
    @Column(name = "FP3_DATE")
    private String fp3_date;
    @Column(name = "FP3_TIME")
    private String fp3_time;
    @Column(name = "QUALI_DATE")
    private String quali_date;
    @Column(name = "QUALI_TIME")
    private String quali_time;
    @Column(name = "SPRINT_DATE")
    private String sprint_date;
    @Column(name = "SPRINT_TIME")
    private String sprint_time;


}

package com.governarti.formulaRace.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "qualifies")
@Getter
@Setter
public class Qualify {

    public Qualify() {}

    public Qualify(int qualifyId, int raceId, int driverId, int constructorId, String number, int position, String q1, String q2, String q3) {
        this.qualifyId = qualifyId;
        this.raceId = raceId;
        this.driverId = driverId;
        this.constructorId = constructorId;
        this.number = number;
        this.position = position;
        this.q1 = q1;
        this.q2 = q2;
        this.q3 = q3;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "QUALIFY_ID", nullable = false)
    private int qualifyId;
    @Column(name = "RACE_ID", nullable = false)
    private int raceId;
    @Column(name = "DRIVER_ID", nullable = false)
    private int driverId;
    @Column(name = "CONSTRUCTOR_ID", nullable = false)
    private int constructorId;
    @Column(name = "NUMBER", nullable = false)
    private String number;
    @Column(name = "POSITION")
    private int position;
    @Column(name = "Q1", nullable = false)
    private String q1;
    @Column(name = "Q2", nullable = false)
    private String q2;
    @Column(name = "Q3", nullable = false)
    private String q3;

}

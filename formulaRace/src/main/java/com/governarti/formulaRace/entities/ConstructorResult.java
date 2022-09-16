package com.governarti.formulaRace.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "constructor_results")
@Getter
@Setter
public class ConstructorResult {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CONSTRUCTOR_RESULTS_ID", nullable = false)
    private int constructorResultsId;
    @Column(name = "RACE_ID", nullable = false)
    private int raceId;
    @Column(name = "CONSTRUCTOR_ID", nullable = false)
    private int constructorId;
    @Column(name = "POINTS", nullable = false)
    private double points;
    @Column(name = "STATUS")
    private String status;

    public ConstructorResult() {}

    public ConstructorResult(int constructorResultsId, int raceId, int constructorId, double points, String status) {
        this.constructorResultsId = constructorResultsId;
        this.raceId = raceId;
        this.constructorId = constructorId;
        this.points = points;
        this.status = status;
    }
}

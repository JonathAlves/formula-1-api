package com.governarti.formulaRace.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "constructor_standings")
@Getter
@Setter
public class ConstructorStanding {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CONSTRUCTOR_STANDINGS_ID")
    private int constructorStandingsId;
    @Column(name = "RACE_ID", nullable = false)
    private int raceId;
    @Column(name = "CONSTRUCTOR_ID", nullable = false)
    private int constructorId;
    @Column(name = "POINTS", nullable = false)
    private double points;
    @Column(name = "POSITION", nullable = false)
    private int position;
    @Column(name = "POSITION_TEXT", nullable = false)
    private String positionText;
    @Column(name = "WINS", nullable = false)
    private int wins;

    public ConstructorStanding(){}

    public ConstructorStanding(int constructorStandingsId, int raceId, int constructorId, double points, int position, String positionText, int wins) {
        this.constructorStandingsId = constructorStandingsId;
        this.raceId = raceId;
        this.constructorId = constructorId;
        this.points = points;
        this.position = position;
        this.positionText = positionText;
        this.wins = wins;
    }
}

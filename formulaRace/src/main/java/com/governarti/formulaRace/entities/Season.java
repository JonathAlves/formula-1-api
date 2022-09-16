package com.governarti.formulaRace.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "seasons")
@Getter
@Setter
public class Season {
    public Season() {}

    public Season(int year, String url) {
        this.year = year;
        this.url = url;
    }

    public Season(int id, int year, String url) {
        this.id = id;
        this.year = year;
        this.url = url;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "YEAR_")
    private int year;
    @Column(name = "URL")
    private String url;
}

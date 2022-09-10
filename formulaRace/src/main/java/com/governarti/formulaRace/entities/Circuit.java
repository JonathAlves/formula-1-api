package com.governarti.formulaRace.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Table(name = "circuit")
@Entity
@Getter
@Setter
public class Circuit {

    public Circuit(){}

    public Circuit(int circuitId, String circuitRef, String name, String location, String country, String latitude, String longitude, String altitude, String url) {
        this.circuitId = circuitId;
        this.circuitRef = circuitRef;
        this.name = name;
        this.location = location;
        this.country = country;
        this.latitude = latitude;
        this.longitude = longitude;
        this.altitude = altitude;
        this.url = url;
    }
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", nullable = false)
    private int circuitId;
    @Column(name = "CIRCUIT_REF", length = 120, nullable = false)
    private String circuitRef;
    @Column(name = "NAME", length = 120, nullable = false)
    private String name;
    @Column(name = "LOCATION", length = 120, nullable = false)
    private String location;
    @Column(name = "COUNTRY", length = 120, nullable = false)
    private String country;
    @Column(name = "LATITUDE", nullable = false)
    private String latitude;
    @Column(name = "LONGITUDE", nullable = false)
    private String longitude;
    @Column(name = "ALTITUDE", nullable = false)
    private String altitude;
    @Column(name = "URL", nullable = false)
    private String url;


}

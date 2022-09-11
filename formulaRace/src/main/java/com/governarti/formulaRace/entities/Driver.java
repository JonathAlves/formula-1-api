package com.governarti.formulaRace.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "drivers")
@Getter
@Setter
public class Driver {

    public Driver(){}

    public Driver(int driverId, String driverRef, String number, String code, String forename, String surname, String dob, String nationality, String url) {
        this.driverId = driverId;
        this.driverRef = driverRef;
        this.number = number;
        this.code = code;
        this.forename = forename;
        this.surname = surname;
        this.dob = dob;
        this.nationality = nationality;
        this.url = url;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "DRIVER_ID", nullable = false)
    private int driverId;
    @Column(name = "DRIVER_REF", nullable = false)
    private String driverRef;
    @Column(name = "NUMBER", nullable = false)
    private String number;
    @Column(name = "CODE", nullable = false)
    private String code;
    @Column(name = "FORENAME", nullable = false)
    private String forename;
    @Column(name = "SURNAME", nullable = false)
    private String surname;
    @Column(name = "DOB", nullable = false)
    private String dob;
    @Column(name = "NATIONALITY", nullable = false)
    private String nationality;
    @Column(name = "URL", nullable = false)
    private String url;

}

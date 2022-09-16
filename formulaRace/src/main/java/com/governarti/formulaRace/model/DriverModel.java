package com.governarti.formulaRace.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;


@Getter
@Setter
@RequiredArgsConstructor
public class DriverModel {
    private int driverId;
    private String givenName;
    private String familyName;
    private LocalDate dateOfBirth;
    private String nationality;
    private int wins;
    private String url;
}


package com.governarti.formulaRace.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@RequiredArgsConstructor
public class DriverModel {
    private int driverId;
    private String givenName;
    private String familyName;
    private String dateOfBirth;
    private String nationality;
    private int wins;
    private String url;
}


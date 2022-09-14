package com.governarti.formulaRace.model;

import com.governarti.formulaRace.entities.Constructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@RequiredArgsConstructor
public class DriverMoreTeamsModel {
    private int driverId;
    private String givenName;
    private String familyName;
    private LocalDate dateOfBirth;
    private String nationality;
    private List<Constructor> constructors;
}

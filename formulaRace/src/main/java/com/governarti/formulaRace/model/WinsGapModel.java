package com.governarti.formulaRace.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@RequiredArgsConstructor
@Getter
@Setter
public class WinsGapModel {
    private int driverId;
    private String givenName;
    private String familyName;
    private LocalDate dateOfBirth;
    private String nationality;
    private int firstWin;
    private int lastWin;
}

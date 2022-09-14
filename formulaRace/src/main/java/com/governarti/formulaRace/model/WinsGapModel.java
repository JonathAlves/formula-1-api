package com.governarti.formulaRace.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@RequiredArgsConstructor
@Getter
@Setter
public class WinsGapModel {
    private int driverId;
    private String givenName;
    private String familyName;
    private String dateOfBirth;
    private String nationality;
    private int firstWin;
    private int lastWin;
}

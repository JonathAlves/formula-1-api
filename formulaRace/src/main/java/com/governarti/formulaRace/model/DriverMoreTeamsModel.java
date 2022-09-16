package com.governarti.formulaRace.model;

import com.governarti.formulaRace.entities.Constructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;

@Getter
@Setter
@RequiredArgsConstructor
public class DriverMoreTeamsModel implements Comparable<DriverMoreTeamsModel> {
    private int driverId;
    private String givenName;
    private String familyName;
    private LocalDate dateOfBirth;
    private String nationality;
    private List<Constructor> constructors;

    @Override
    public int compareTo(DriverMoreTeamsModel o) {
        if(o.getConstructors() == null || this.getConstructors() == null){
            return 0;
        }else {
            return o.getConstructors().size() - this.getConstructors().size();
        }
    }
}

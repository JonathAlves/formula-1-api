package com.governarti.formulaRace.controller;

import com.governarti.formulaRace.model.DriverMoreTeamsModel;
import com.governarti.formulaRace.service.DriverMoreTeamsService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/drivers")
@RequiredArgsConstructor
public class DriverMoreTeamsController {
    @Autowired
    private final DriverMoreTeamsService driverMoreTeamsService;

    @GetMapping("/teams")
    public ResponseEntity<List<DriverMoreTeamsModel>> getDriversMoreTeams(){
        List list = driverMoreTeamsService.getDriversMoreTeams();
        return ResponseEntity.ok(list);
    }
}

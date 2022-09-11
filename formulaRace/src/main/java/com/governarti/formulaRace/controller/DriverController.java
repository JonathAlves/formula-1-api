package com.governarti.formulaRace.controller;

import com.governarti.formulaRace.entities.Driver;
import com.governarti.formulaRace.service.DriverService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/drivers")
@RequiredArgsConstructor
public class DriverController {
    @Autowired
    private final DriverService driverService;

    @GetMapping("/winning")
    public ResponseEntity<List<Optional<Driver>>> getByOneWin(){
        List list = driverService.getDriversByOneWin();
        return ResponseEntity.ok(list);
    }
}

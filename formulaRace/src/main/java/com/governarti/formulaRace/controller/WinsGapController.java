package com.governarti.formulaRace.controller;

import com.governarti.formulaRace.model.WinsGapModel;
import com.governarti.formulaRace.service.WinsGapService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/drivers")
@RequiredArgsConstructor
public class WinsGapController {

    @Autowired
    private WinsGapService winsGapService;

    @GetMapping("/wins-gap")
    public ResponseEntity<WinsGapModel> getWinsGap(){
        WinsGapModel wgModel = winsGapService.getWinsGap();
        return ResponseEntity.ok(wgModel);
    }
}

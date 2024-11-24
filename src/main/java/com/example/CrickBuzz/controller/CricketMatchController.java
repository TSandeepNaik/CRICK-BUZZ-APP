package com.example.CrickBuzz.controller;

import com.example.CrickBuzz.dto.request.CricketMatchRequest;
import com.example.CrickBuzz.dto.response.CricketMatchResponse;
import com.example.CrickBuzz.exeptions.TeamNotFoundException;
import com.example.CrickBuzz.service.CricketMatchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/matches")
public class CricketMatchController {

    @Autowired
    CricketMatchService cricketMatchService;

    @PostMapping
    public ResponseEntity registerMatches(@RequestBody CricketMatchRequest cricketMatchRequest,
                                          @RequestParam int team1,
                                          @RequestParam int team2) {
        //let's handle the exception
        try {
            return new ResponseEntity(cricketMatchService.registerMatch(cricketMatchRequest, team1, team2),
                    HttpStatus.CREATED);
        } catch (TeamNotFoundException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }



}

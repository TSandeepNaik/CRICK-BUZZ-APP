package com.example.CrickBuzz.controller;

import com.example.CrickBuzz.dto.request.TeamRequest;
import com.example.CrickBuzz.dto.response.TeamResponse;
import com.example.CrickBuzz.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/team")
public class TeamController {

    @Autowired
    TeamService teamService;

    @PostMapping
    public ResponseEntity<TeamResponse> addTeam(@RequestBody TeamRequest teamRequest){
        return new ResponseEntity<>(teamService.addTeam(teamRequest), HttpStatus.CREATED);
    }
}

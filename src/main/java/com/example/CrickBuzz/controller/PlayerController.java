package com.example.CrickBuzz.controller;

import com.example.CrickBuzz.converter.PlayerConverter;
import com.example.CrickBuzz.dto.request.PlayerRequest;
import com.example.CrickBuzz.dto.response.PlayerResponse;
import com.example.CrickBuzz.model.Player;
import com.example.CrickBuzz.model.enums.Speciality;
import com.example.CrickBuzz.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/player")
public class PlayerController {

    @Autowired
    PlayerService playerService;

    //api for saving the player
    @PostMapping
    public PlayerResponse addPlayerCont(@RequestBody PlayerRequest playerRequest){
        return playerService.addPlayer(playerRequest);
    }

    @GetMapping("/age/{age}")
    public List<PlayerResponse> playersByAge(@PathVariable("age") int age){
        return playerService.FindPlayerGreaterThenAge(age);
    }

    @GetMapping("/age/{age}/speciality/{speciality}")
    public List<PlayerResponse> playerByAgeGreaterThanAndSpeciality(@PathVariable("age") int age, @PathVariable("speciality") Speciality speciality){
        return playerService.playerByAgeGreaterThanAndSpeciality(age, speciality);
    }

    @GetMapping
    public  Player getPlayerById(@RequestParam int playerId){
        return playerService.getPlayer(playerId);
    }
}

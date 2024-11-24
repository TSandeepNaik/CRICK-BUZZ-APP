package com.example.CrickBuzz.controller;

import com.example.CrickBuzz.dto.request.PlayerProfileRequest;
import com.example.CrickBuzz.dto.request.PlayerRequest;
import com.example.CrickBuzz.dto.response.PlayerProfileResponse;
import com.example.CrickBuzz.dto.response.PlayerResponse;
import com.example.CrickBuzz.exeptions.PlayerNotFoundException;
import com.example.CrickBuzz.service.PlayerProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/profile")
public class PlayerProfileController {

    @Autowired
    PlayerProfileService playerProfileService;

    //ResponseEntity will help us to send both content and the http request properly like spring will give 200 ok for all
    //the succuss msg  but response entity can specify it with 201 created
    //and we can also send the different data type
    @PostMapping
    public ResponseEntity addPlayerProfile(@RequestBody PlayerProfileRequest playerProfileRequest, @RequestParam("player-id") int playerId){
        //if it throw the error we should handle it so lets put it in a try catch block
        try {
            return new ResponseEntity(playerProfileService.addProfile(playerProfileRequest, playerId), HttpStatus.CREATED);
        } catch (PlayerNotFoundException e) {
            //here because of response entity it will written the different datatype at once
            return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
            }
    }

}

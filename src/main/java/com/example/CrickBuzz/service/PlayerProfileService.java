package com.example.CrickBuzz.service;

import com.example.CrickBuzz.converter.PlayerProfileConverter;
import com.example.CrickBuzz.dto.request.PlayerProfileRequest;
import com.example.CrickBuzz.dto.response.PlayerProfileResponse;
import com.example.CrickBuzz.exeptions.PlayerNotFoundException;
import com.example.CrickBuzz.model.Player;
import com.example.CrickBuzz.model.PlayerProfile;
import com.example.CrickBuzz.repository.PlayerProfileRepository;
import com.example.CrickBuzz.repository.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PlayerProfileService {

    @Autowired
    PlayerRepository playerRepository; //first need to check the player exist or not

    @Autowired
    PlayerProfileRepository playerProfileRepository;

    //method to add the playerProfile
    public PlayerProfileResponse addProfile(PlayerProfileRequest playerProfileRequest, int playerId){
/*
        Optional<Player> optionalPlayer = playerRepository.findById(playerId); //it will written the optional object means if student is not there it will written null
        if(optionalPlayer.isEmpty()){
            throw new PlayerNotFoundException("Invalid PlayerId");
        }
        //else will get the object /Player
         Player player =  optionalPlayer.get();
*/
        //we can write the above in single line also
        Player player = playerRepository.findById(playerId)
                .orElseThrow( () -> new PlayerNotFoundException("Invalid PlayerID"));

        PlayerProfile playerProfile = PlayerProfileConverter.convertPlayerProfileDtoToPlayerProfile(playerProfileRequest);

        //now we have to set the player profile in player and player in player profile
        playerProfile.setPlayer(player);
        player.setPlayerProfile(playerProfile);

       Player savedPlayer = playerRepository.save(player);  //it will also save the playerRepository also bcs used cascadeAll in player

        //here we dont have saved playerProfile but we player have profile we can get it from that
        return PlayerProfileConverter.PlayerProfileToPlayerProfileResponse(savedPlayer.getPlayerProfile());

    }

}

package com.example.CrickBuzz.converter;


import com.example.CrickBuzz.dto.request.PlayerRequest;
import com.example.CrickBuzz.dto.response.PlayerResponse;
import com.example.CrickBuzz.model.Player;

public class PlayerConverter {

    public static Player PlayerDtoToPlayer(PlayerRequest playerRequest){
        return Player.builder()
                .name(playerRequest.getName())
                .age(playerRequest.getAge())
                .gender(playerRequest.getGender())
                .speciality(playerRequest.getSpeciality())
                .email(playerRequest.getEmail())
                .build();
    }

    public  static PlayerResponse PlayerToPlayerResponse(Player player){
        return PlayerResponse.builder()
                .name(player.getName())
                .speciality(player.getSpeciality())
                .build();
    }
}

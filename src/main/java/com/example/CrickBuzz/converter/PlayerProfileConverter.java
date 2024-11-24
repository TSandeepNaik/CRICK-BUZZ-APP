package com.example.CrickBuzz.converter;

import com.example.CrickBuzz.dto.request.PlayerProfileRequest;
import com.example.CrickBuzz.dto.response.PlayerProfileResponse;
import com.example.CrickBuzz.dto.response.PlayerResponse;
import com.example.CrickBuzz.model.PlayerProfile;

public class PlayerProfileConverter {
     public static PlayerProfile convertPlayerProfileDtoToPlayerProfile(PlayerProfileRequest playerProfileRequest){
         return PlayerProfile.builder()
                 .battingAvg(playerProfileRequest.getBattingAvg())
                 .bowlingAvg(playerProfileRequest.getBowlingAvg())
                 .runScored(playerProfileRequest.getRunScored())
                 .wicketTaken(playerProfileRequest.getWicketTaken())
                 .build();
     }
     public static PlayerProfileResponse PlayerProfileToPlayerProfileResponse(PlayerProfile playerProfile){
         return PlayerProfileResponse.builder()
                 .battingAvg(playerProfile.getBattingAvg())
                 .bowlingAvg(playerProfile.getBowlingAvg())
                 .runScored(playerProfile.getRunScored())
                 .wicketTaken(playerProfile.getWicketTaken())
                 //playerProfile has the player object will tale from that and will convert it and pass as a value
                 .player(PlayerConverter.PlayerToPlayerResponse(playerProfile.getPlayer()))
                 .build();
     }
}

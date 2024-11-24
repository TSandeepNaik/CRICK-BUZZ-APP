package com.example.CrickBuzz.dto.response;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class PlayerProfileResponse {

    int runScored;

    int wicketTaken;

    double battingAvg;

    double bowlingAvg;

    //if i want to show the player details along with this profile then i can call player response
    PlayerResponse player;
}

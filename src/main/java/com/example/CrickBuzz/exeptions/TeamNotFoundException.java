package com.example.CrickBuzz.exeptions;

import com.example.CrickBuzz.model.Team;

public class TeamNotFoundException extends RuntimeException{
    public TeamNotFoundException(String message){
        super(message);
    }
}

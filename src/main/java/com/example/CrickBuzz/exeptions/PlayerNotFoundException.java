package com.example.CrickBuzz.exeptions;

public class PlayerNotFoundException extends RuntimeException{

    //will override the constructor and initialise the msg with the string
    public PlayerNotFoundException(String message){
        super(message);
    }
}

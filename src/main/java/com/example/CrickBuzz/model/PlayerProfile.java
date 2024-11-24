package com.example.CrickBuzz.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Data  //for getter setter
@NoArgsConstructor
@AllArgsConstructor
@Entity  //it will tell that it is model class
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)  //for setting private access modifier
public class PlayerProfile {

    @Id //for primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY)  //for autoGenerating the id
    int id;

    int runScored;

    int wicketTaken;

    double battingAvg;

    double bowlingAvg;

    @OneToOne
    @JoinColumn  // here we want to join the player id as a foreign key so we r joining the column
    @JsonBackReference  //class which has foreign key will have backreference generally
    Player player;
}

package com.example.CrickBuzz.model;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Data  //for getter setter
@NoArgsConstructor
@AllArgsConstructor
@Entity  //it will tell that it is model class
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)  //for setting private access modifier
public class Team {

    @Id //for primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY) // generating the id automatically
    int id;

    String name;

    int ranking;

    int iccPoints;

    String coach;

    @OneToMany(mappedBy = "team") // we don't use cascade here if player get deleted then also team can exist or wise versa
    List<Player> players;

    @ManyToMany(mappedBy = "teams")
    List<CricketMatch> matches;
}

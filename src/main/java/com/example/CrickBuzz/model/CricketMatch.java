package com.example.CrickBuzz.model;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.CreationTimestamp;

import java.util.Date;
import java.util.List;

@Data  //for getter setter
@NoArgsConstructor
@AllArgsConstructor
@Entity  //it will tell that it is model class
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)  //for setting private access modifier
public class CricketMatch {

    @Id //for primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY) // generating the id automatically
    int id;

    String title;

    String venue;

    int numOfOvers;

    @CreationTimestamp  //to store the created date along with the time
    Date createdDate;

    @ManyToMany
     //for creating the extra table that holds the foreign key of both the table
    @JoinTable(name = "team_match",joinColumns = @JoinColumn(name = "crick_match_id"),
                                    inverseJoinColumns = @JoinColumn(name = "team_id"))
    List<Team> teams;
}

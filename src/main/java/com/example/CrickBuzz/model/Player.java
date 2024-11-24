package com.example.CrickBuzz.model;

import com.example.CrickBuzz.model.enums.Gender;
import com.example.CrickBuzz.model.enums.Speciality;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.Cascade;

@Data  //for getter setter
@NoArgsConstructor
@AllArgsConstructor
@Entity  //it will tell that it is model class
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE) //it will set the private infront of all the variable like private int id etc
//to maintain encapsulation we use private to all the variable this annotation will handle that
//it may make our all methods and constructors also private then it of no use but  it doesn't bcs it has the lowest priority
// means if we write public int id java will take it as public even though we have FieldDefault annotation
public class Player {

    @Id  //to make primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY)  //it will be generated automatically
    int id;

    String name;

    int age;

    @Enumerated(value = EnumType.STRING) //it will convert the number value of enum to the string value we given
    Gender gender;

    @Enumerated(value = EnumType.STRING)
    Speciality speciality;

    @OneToOne(mappedBy = "player", cascade = CascadeType.ALL) // here cascadeAll - if we delete the player simultaneously player profile also get deleted
    @JsonManagedReference  //for reference we always use JsonManagedReference on cascade side means both player and the profile managed here that y if u go to
    // profile it will written the backReference means it is already managed in player class only no need to manage here
    PlayerProfile playerProfile;    // but if we delete player profile there student will not be deleted only profile will get deleted

    @ManyToOne
    @JoinColumn
    Team team;

}

package com.example.CrickBuzz.dto.response;


import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE) //to make all the field private
public class TeamResponse {

    String name;

    int ranking;

    String coach;

}

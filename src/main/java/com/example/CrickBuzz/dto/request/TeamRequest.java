package com.example.CrickBuzz.dto.request;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE) //to make all the field private
public class TeamRequest {

    String name;

    int ranking;

    int iccPoints;

    String coach;

}

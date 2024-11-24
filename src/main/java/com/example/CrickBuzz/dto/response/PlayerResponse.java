package com.example.CrickBuzz.dto.response;

import com.example.CrickBuzz.model.enums.Speciality;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE) // to make all the attributes private
public class PlayerResponse {
     // in this class u can decide what u want to show to ur clint
    String name;

    Speciality speciality;
}

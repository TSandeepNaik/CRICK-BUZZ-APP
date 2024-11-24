package com.example.CrickBuzz.dto.request;

import com.example.CrickBuzz.model.enums.Gender;
import com.example.CrickBuzz.model.enums.Speciality;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE) // to make all the attributes private
public class PlayerRequest {

    String name;

    int age;

    Gender gender;

    Speciality speciality;
}

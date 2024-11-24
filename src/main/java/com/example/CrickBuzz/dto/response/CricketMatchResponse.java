package com.example.CrickBuzz.dto.response;

import com.example.CrickBuzz.model.Team;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CricketMatchResponse {
    String title;

    String venue;

    int numOfOvers;

    Date createdDate;

    List<TeamResponse> teams;
}

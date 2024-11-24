package com.example.CrickBuzz.converter;

import com.example.CrickBuzz.dto.request.TeamRequest;
import com.example.CrickBuzz.dto.response.TeamResponse;
import com.example.CrickBuzz.model.Team;

public class TeamConverter {

    public static Team TeamRequestDtoToTeam(TeamRequest teamRequest){
        return Team.builder()
                .name(teamRequest.getName())
                .coach(teamRequest.getCoach())
                .ranking(teamRequest.getRanking())
                .iccPoints(teamRequest.getIccPoints())
                .build();
    }

    public static TeamResponse savedTeamToTeamResponse(Team team){
        return TeamResponse.builder()
                .name(team.getName())
                .coach(team.getCoach())
                .ranking(team.getRanking())
                .build();
    }
}

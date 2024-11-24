package com.example.CrickBuzz.service;

import com.example.CrickBuzz.converter.TeamConverter;
import com.example.CrickBuzz.dto.request.TeamRequest;
import com.example.CrickBuzz.dto.response.TeamResponse;
import com.example.CrickBuzz.model.Team;
import com.example.CrickBuzz.repository.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TeamService {

     @Autowired
    TeamRepository teamRepository;

     //method to add the teams which will written the team response
    public TeamResponse addTeam(TeamRequest teamRequest){
        Team team = TeamConverter.TeamRequestDtoToTeam(teamRequest);

        Team savedTeam = teamRepository.save(team);

        return TeamConverter.savedTeamToTeamResponse(savedTeam);

    }


}

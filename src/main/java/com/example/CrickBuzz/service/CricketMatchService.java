package com.example.CrickBuzz.service;

import com.example.CrickBuzz.converter.CricketMatchConveter;
import com.example.CrickBuzz.dto.request.CricketMatchRequest;
import com.example.CrickBuzz.dto.response.CricketMatchResponse;
import com.example.CrickBuzz.exeptions.PlayerNotFoundException;
import com.example.CrickBuzz.exeptions.TeamNotFoundException;
import com.example.CrickBuzz.model.CricketMatch;
import com.example.CrickBuzz.model.Team;
import com.example.CrickBuzz.repository.CricketMatchRepository;
import com.example.CrickBuzz.repository.PlayerRepository;
import com.example.CrickBuzz.repository.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.sound.midi.Track;
import java.util.Optional;

@Service
public class CricketMatchService {

    @Autowired
    CricketMatchRepository cricketMatchRepository;

    //to check the teams are valid are not
    @Autowired
    TeamRepository teamRepository;

    public CricketMatchResponse registerMatch(CricketMatchRequest cricketMatchRequest, int teamAId, int teamBId){
        //first we will check the teams are valid are not
      Optional<Team> teamA = teamRepository.findById(teamAId);
        Optional<Team> teamB = teamRepository.findById(teamBId);

        // if one of the team id is not valid then we will throw an exception
        if(teamA.isEmpty() || teamB.isEmpty()){
            throw  new TeamNotFoundException("one or more team(s) id are not valid");
        }
        //will get the teams by optional team
        Team team1 = teamA.get();
        Team team2 = teamB.get();

   // now we have to check the respective model class that anything is there which we need to  change which may affect if we dont change
        //means mappings
        //here we need to set the cricket match for both the teams and team for the cricket match

        CricketMatch cricketMatch = CricketMatchConveter.cricketMatchRequestToCricketMatch(cricketMatchRequest);
       cricketMatch.getTeams().add(team1);
       cricketMatch.getTeams().add(team2);

       team1.getMatches().add(cricketMatch);
       team2.getMatches().add(cricketMatch);   // here we are adding same cricket match for both the teams
 // now we have to save the cricket match
        CricketMatch savedCricketMatch = cricketMatchRepository.save(cricketMatch);

        //  now we have to return the cricket match response

        return CricketMatchConveter.matchToMatchResponse(savedCricketMatch);


            }
}

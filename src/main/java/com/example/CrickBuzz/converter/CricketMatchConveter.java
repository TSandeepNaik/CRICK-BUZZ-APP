package com.example.CrickBuzz.converter;

import com.example.CrickBuzz.dto.request.CricketMatchRequest;
import com.example.CrickBuzz.dto.response.CricketMatchResponse;
import com.example.CrickBuzz.dto.response.TeamResponse;
import com.example.CrickBuzz.model.CricketMatch;
import com.example.CrickBuzz.model.Team;

import java.util.ArrayList;
import java.util.List;



public class CricketMatchConveter {

    public static CricketMatch cricketMatchRequestToCricketMatch(CricketMatchRequest cricketMatchRequest){
      return  CricketMatch.builder()
                .title(cricketMatchRequest.getTitle())
                .venue(cricketMatchRequest.getVenue())
                .numOfOvers(cricketMatchRequest.getNumOfOvers())
                .teams(new ArrayList<>()) //here we are setting the teams as am empty arrayList so that we can save the teams in cricket match
                // else builder will make it null automatically then we get the null insread of team details in the data base
                .build();
    }

    public static CricketMatchResponse matchToMatchResponse(CricketMatch match) {
       //to return the teams along with the match details
        Team team1 = match.getTeams().get(0);  //it will give 1st team
        Team team2 = match.getTeams().get(1);  // it will give 2nd team
    //we can not return the team entities so we create the list of team response and we add the teams response to the list and return it
        List<TeamResponse> teamResponses = new ArrayList<>();
        teamResponses.add(TeamConverter.savedTeamToTeamResponse(team1));  // he are also we can not save the team entity so we are converting it into teamResponse
        teamResponses.add(TeamConverter.savedTeamToTeamResponse(team2));


       return CricketMatchResponse.builder()
                .title(match.getTitle())
                .venue(match.getVenue())
                .numOfOvers(match.getNumOfOvers())
                .createdDate(match.getCreatedDate())
               .teams(teamResponses)
                .build();

    }
}

package com.example.demo.service;

import com.example.demo.dto.Game;
import com.example.demo.dto.Player;
import com.example.demo.dto.Team;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class GameActivityService {

    @Autowired
    private TeamActivityService teamActivityService;

    public void createGame(Integer overs, Integer noOfPlayers, String MembersTeam1, String MembersTeam2, Integer battingTeam ){
        String[] parts1 = MembersTeam1.split(",");
        List<String> stringList1 = new ArrayList<>();
        for (String part : parts1) {
            String trimmedPart = part.trim(); // Remove spaces
            stringList1.add(trimmedPart);
        }
        Team team1 = new Team(noOfPlayers);
        List<Player> tempP1 = new ArrayList<>();
        for (String item : stringList1) {
            tempP1.add(new Player(item));
        }
        team1.setListOfPlayers(tempP1);
        team1.initializeStrike();

        //team2
        String[] parts2 = MembersTeam2.split(",");
        List<String> stringList2 = new ArrayList<>();
        for (String part : parts2) {
            String trimmedPart = part.trim(); // Remove spaces
            stringList2.add(trimmedPart);
        }
        Team team2 = new Team(noOfPlayers);
        List<Player> tempP2 = new ArrayList<>();
        for (String item : stringList2) {
            tempP2.add(new Player(item));
        }
        team2.setListOfPlayers(tempP2);
        team2.initializeStrike();


        Game.setTeam1(team1);
        Game.setTeam2(team2);
        Game.setOverPerTeam(overs);
        Game.setBattingTeam(battingTeam);
        Game.setCurrentTeam(battingTeam);



    }

    public void addRuns(String runs){
        String[] parts = runs.split(",");
        List<String> stringList = new ArrayList<>();
        for (String part : parts) {
            String trimmedPart = part.trim(); // Remove spaces
            stringList.add(trimmedPart);
        }

        for (String item : stringList) {
           if(Game.currentTeam==1){
               Game.team1=teamActivityService.addScore(item,Game.team1);
               if(Game.team1.getBallsPlayed()/6==Game.getOverPerTeam() || Game.team1.getTotalWicketsFallen()>=Game.team1.getNumberOfPlayers()-1 ){
                   Game.setCurrentTeam(2);
               }

           }
           else{
               Game.team2=teamActivityService.addScore(item,Game.team2);
               if(Game.team2.getBallsPlayed()/6==Game.getOverPerTeam() ||  Game.team2.getTotalWicketsFallen()>=Game.team2.getNumberOfPlayers()-1){
                   Game.setCurrentTeam(1);
               }
           }
        }

    }
}

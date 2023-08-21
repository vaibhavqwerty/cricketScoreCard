package com.example.demo.service;

import com.example.demo.dto.Player;
import com.example.demo.dto.Team;
import com.example.demo.interfaces.TeamActivityInterface;
import org.hibernate.service.spi.InjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class TeamActivityService implements TeamActivityInterface {

    private Team team;

    @Autowired
    private PlayerAcitivityService playerAcitivityService;


    @Override
    public Team addPlayer(String playerName, Team team) {

        this.team=team;

        Player player= new Player(playerName);

        List<Player> tempList=this.team.getListOfPlayers();

        tempList.add(player);

        this.team.setListOfPlayers(tempList);

        return this.team;
    }

    @Override
    public Team addScore(String runs, Team team) {

        this.team=team;

        if(runs.equals("W")) {
            addWicket();
            addBall();
        }
        else if(runs.equals("Wd"))
            addRun("1",true);
        else {
            addRun(runs,false);
            addBall();
        }

        this.team.setOverPlayed(this.team.getBallsPlayed()/6+(.1*(this.team.getBallsPlayed()%6)));
        return team;
    }

    @Override
    public int getScore(Team team) {
        return team.getTotalScore();
    }

    private void addWicket(){

        List<Player> tempList=this.team.getListOfPlayers();

        int wickets=0;
        for(int j=0;j<tempList.size();j++){
            Player p=tempList.get(j);

            if(p.getName().equals(team.getOnStrikeName()))
            {
                p.setStatus("out");
                tempList.set(j,p);
            }
            if(p.getStatus().equals("notPlayed")){
                p.setStatus("notOut");
                team.setOnStrikeName(p.getName());
                tempList.set(j,p);
                break;
            }


        }
        this.team.setTotalWicketsFallen(this.team.getTotalWicketsFallen()+1);

        team.setListOfPlayers(tempList);
    }


    @Override
    public int getWickets(Team team) {
        List<Player> tempList=this.team.getListOfPlayers();

        int wickets=0;
        for(int j=0;j<tempList.size();j++){
            Player p=tempList.get(j);

            if(p.getStatus().equals("out"))
                wickets+=wickets;

        }

        return wickets;

    }


    private void addBall(){
        team.setBallsPlayed(team.getBallsPlayed()+1);

        if(team.getBallsPlayed()%6==0)
            changeStrike();

    }

    private void changeStrike(){
        String OnStrikeName=team.getOnStrikeName();
        team.setOnStrikeName(team.getOnNonStrikeName());
        team.setOnNonStrikeName(OnStrikeName);
    }

    private void addRun(String run,boolean isExtra){
            int i=Integer.parseInt(run);
            team.setTotalScore(team.getTotalScore()+i);


        List<Player> tempList=this.team.getListOfPlayers();

        for(int j=0;j<tempList.size();j++){
            Player p=tempList.get(j);

            if(p.getName().equals(team.getOnStrikeName())){
                Player newp=playerAcitivityService.addRun(i,p,isExtra);
                tempList.set(j,newp);
            }
        }

        team.setListOfPlayers(tempList);

        if(i%2!=0 && !isExtra){
            changeStrike();
        }









    }




}

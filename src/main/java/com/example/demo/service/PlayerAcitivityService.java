package com.example.demo.service;


import com.example.demo.dto.Player;
import com.example.demo.interfaces.PlayerActivityInterface;
import org.springframework.stereotype.Service;

@Service
public class PlayerAcitivityService implements PlayerActivityInterface {

    Player player;

    @Override
    public Player addRun(int runs, Player player, boolean isExtra) {

        this.player=player;




        if(!isExtra){
            this.player.setRuns(this.player.getRuns()+runs);
            addBall();
        }


        if(runs==4)
            addFour();
        if(runs==6)
            addSix();

        return this.player;
    }

    @Override
    public Player changeStatus(String newStatus, Player player) {
        this.player=player;

        this.player.setStatus(newStatus);
        return this.player;
    }


    private void addBall(){
        this.player.setBalls(this.player.getBalls()+1);
    }

    private void addFour(){
        this.player.setFours(this.player.getFours()+1);
    }

    private void addSix(){
        this.player.setSixes(this.player.getSixes()+1);
    }



}

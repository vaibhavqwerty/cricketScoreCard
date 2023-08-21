package com.example.demo.interfaces;

import com.example.demo.dto.Team;

public interface TeamActivityInterface {

    public Team addPlayer(String playerName, Team team);

    public Team addScore(String runs, Team team);

    public int getScore(Team team);

    public int  getWickets( Team team);
}

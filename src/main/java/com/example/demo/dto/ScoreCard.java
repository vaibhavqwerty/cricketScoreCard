package com.example.demo.dto;

public class ScoreCard {
    String playingTeam;

    Team team;

    public ScoreCard(String playingTeam, Team team) {
        this.playingTeam = playingTeam;
        this.team = team;
    }

    public String getPlayingTeam() {
        return playingTeam;
    }

    public void setPlayingTeam(String playingTeam) {
        this.playingTeam = playingTeam;
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }
}

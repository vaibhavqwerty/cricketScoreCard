package com.example.demo.dto;

public class Game {

     public static Team team1;

    public static Team team2;

    public static int OverPerTeam;

    public static int battingTeam;

    public static int currentTeam;

    public Game(Team team1, Team team2,Integer overPerTeam, Integer currentTeam, Integer battingTeam) {
            Game.team1=team1;
            Game.team2=team2;
            Game.OverPerTeam=overPerTeam;
            Game.battingTeam=battingTeam;
            Game.currentTeam=currentTeam;
        }




    public  static int getBattingTeam() {
        return battingTeam;
    }

    public static void setBattingTeam(int battingTeam) {
        Game.battingTeam = battingTeam;
    }

    public static  int getCurrentTeam() {
        return currentTeam;
    }

    public static void setCurrentTeam(int currentTeam) {
        Game.currentTeam = currentTeam;
    }

    public static Team getTeam1() {
        return team1;
    }

    public static void setTeam1(Team team1) {
        Game.team1 = team1;
    }

    public static Team getTeam2() {
        return team2;
    }

    public static void setTeam2(Team team2) {
        Game.team2 = team2;
    }

    public static int getOverPerTeam() {
        return OverPerTeam;
    }

    public static void setOverPerTeam(int overPerTeam) {
        Game.OverPerTeam = overPerTeam;
    }
}

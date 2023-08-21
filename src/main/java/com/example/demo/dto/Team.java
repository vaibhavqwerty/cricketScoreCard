package com.example.demo.dto;

import java.util.List;

public class Team {

    private int numberOfPlayers;

    private List<Player> listOfPlayers;

    private int totalScore;

    private int ballsPlayed;

    private double overPlayed;

    private String OnStrikeName;

    private String OnNonStrikeName;

    private Integer totalWicketsFallen;

    public Team(int numberOfPlayers) {
        this.numberOfPlayers = numberOfPlayers;
        this.totalScore = 0;
        this.ballsPlayed = 0;
        this.totalWicketsFallen=0;
    }

    public Integer getTotalWicketsFallen() {
        return totalWicketsFallen;
    }

    public void setTotalWicketsFallen(Integer totalWicketsFallen) {
        this.totalWicketsFallen = totalWicketsFallen;
    }

    public int getNumberOfPlayers() {
        return numberOfPlayers;
    }

    public int getBallsPlayed() {
        return ballsPlayed;
    }

    public void setBallsPlayed(int ballsPlayed) {
        this.ballsPlayed = ballsPlayed;
    }

    public void setNumberOfPlayers(int numberOfPlayers) {
        this.numberOfPlayers = numberOfPlayers;
    }

    public List<Player> getListOfPlayers() {
        return listOfPlayers;
    }

    public void setListOfPlayers(List<Player> listOfPlayers) {
        this.listOfPlayers = listOfPlayers;
    }

    public int getTotalScore() {
        return totalScore;
    }

    public void setTotalScore(int totalScore) {
        this.totalScore = totalScore;
    }

    public double getOverPlayed() {
        return overPlayed;
    }

    public void setOverPlayed(double overPlayed) {
        this.overPlayed = overPlayed;
    }

    public String getOnStrikeName() {
        return OnStrikeName;
    }

    public void setOnStrikeName(String onStrikeName) {
        OnStrikeName = onStrikeName;
    }

    public String getOnNonStrikeName() {
        return OnNonStrikeName;
    }

    public void setOnNonStrikeName(String onNonStrikeName) {
        OnNonStrikeName = onNonStrikeName;
    }

    public void initializeStrike(){

        this.setOnStrikeName(listOfPlayers.get(0).getName());
        this.setOnNonStrikeName(listOfPlayers.get(1).getName());

        Player player1= listOfPlayers.get(0);
        Player player2= listOfPlayers.get(1);

        player1.setStatus("notOut");
        player2.setStatus("notOut");

        listOfPlayers.set(0,player1);
        listOfPlayers.set(1,player2);
    }
}

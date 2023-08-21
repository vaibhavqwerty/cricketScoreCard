package com.example.demo.dto;

public class Player {

    private String name;
    private int balls;
    private int runs;
    private int fours;
    private int sixes;
    private String status; // out,notOut,notPlayed

    public Player(String name) {
        this.name = name;
        this.balls = 0;
        this.runs = 0;
        this.fours = 0;
        this.sixes = 0;
        this.status = "notPlayed";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getBalls() {
        return balls;
    }

    public void setBalls(int balls) {
        this.balls = balls;
    }

    public int getRuns() {
        return runs;
    }

    public void setRuns(int runs) {
        this.runs = runs;
    }

    public int getFours() {
        return fours;
    }

    public void setFours(int fours) {
        this.fours = fours;
    }

    public int getSixes() {
        return sixes;
    }

    public void setSixes(int sixes) {
        this.sixes = sixes;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}

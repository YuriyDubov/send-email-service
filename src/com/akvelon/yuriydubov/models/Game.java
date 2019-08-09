package com.akvelon.yuriydubov.models;

import com.google.gson.annotations.SerializedName;

import java.util.Date;

public class Game {
    @SerializedName("id")
    private String id;

    @SerializedName("date")
    private Date date;

    @SerializedName("home_team")
    private Team homeTeam;

    @SerializedName("home_team_score")
    private int homeTeamScore;

    @SerializedName("visitor_team")
    private Team visitorTeam;

    @SerializedName("visitor_team_score")
    private int visitorTeamScore;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Team getHomeTeam() {
        return homeTeam;
    }

    public void setHomeTeam(Team homeTeam) {
        this.homeTeam = homeTeam;
    }

    public int getHomeTeamScore() {
        return homeTeamScore;
    }

    public void setHomeTeamScore(int homeTeamScore) {
        this.homeTeamScore = homeTeamScore;
    }

    public Team getVisitorTeam() {
        return visitorTeam;
    }

    public void setVisitorTeam(Team visitorTeam) {
        this.visitorTeam = visitorTeam;
    }

    public int getVisitorTeamScore() {
        return visitorTeamScore;
    }

    public void setVisitorTeamScore(int visitorTeamScore) {
        this.visitorTeamScore = visitorTeamScore;
    }
}
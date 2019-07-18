package com.akvelon.yuriydubov.gameProvider;
import org.json.simple.*;

public class Team {
    public String id;
    public String abbreviation;
    public String city;
    public String conference;
    public String division;
    public String full_name;
    public String name;

    public Team(String id, String abbreviation, String city, String conference, String division, String full_name, String name) {
        this.id = id;
        this.abbreviation = abbreviation;
        this.city = city;
        this.conference = conference;
        this.division = division;
        this.full_name = full_name;
        this.name = name;
    }

    public Team(JSONObject jsonTeam) {
        this.id = jsonTeam.get("id").toString();
        this.abbreviation = jsonTeam.get("abbreviation").toString();
        this.city = jsonTeam.get("city").toString();
        this.conference = jsonTeam.get("conference").toString();
        this.division = jsonTeam.get("division").toString();
        this.full_name = jsonTeam.get("full_name").toString();
        this.name = jsonTeam.get("name").toString();
    }
}

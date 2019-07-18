package com.akvelon.yuriydubov.gameProvider;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import com.akvelon.yuriydubov.gameProvider.Team;
import org.json.simple.*;

public class Game {
    public String id;
    // public Date date;
    public String date;
    public Team home_team;
    public int home_team_score;
    public int period;
    public boolean postseason;
    public int season;
    public String status;
    public String time;
    public Team visitor_team;
    public int visitor_team_score;

    public Game (JSONObject jsonGame) {
        try {
            this.id = jsonGame.get("id").toString();
            // SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssZ");
            // String dateInString = jsonGame.get("date").toString();
            // this.date = formatter.parse(dateInString.replaceAll("Z$", "+0000"));
            this.date = jsonGame.get("date").toString();
            this.home_team = new Team((JSONObject) jsonGame.get("home_team"));
            this.home_team_score = Integer.parseInt(jsonGame.get("home_team_score").toString());
            this.period = Integer.parseInt(jsonGame.get("period").toString());
            this.postseason = (Boolean) jsonGame.get("postseason");
            this.season = Integer.parseInt(jsonGame.get("season").toString());
            this.status = jsonGame.get("status").toString();
            this.time = jsonGame.get("time").toString();
            this.visitor_team = new Team((JSONObject) jsonGame.get("visitor_team"));
            this.visitor_team_score = Integer.parseInt(jsonGame.get("visitor_team_score").toString());
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}

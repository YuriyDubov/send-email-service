package com.akvelon.yuriydubov.repositories;

import com.akvelon.yuriydubov.models.Game;

import java.net.HttpURLConnection;
import java.net.URL;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

public class NbaRepository {

    public static List<Game> getAllGames() {
        String urlString = "https://free-nba.p.rapidapi.com/games?page=0&per_page=25";
        try {
                URL url = new URL(urlString);
                HttpURLConnection connect = (HttpURLConnection) url.openConnection();

                connect.setRequestMethod("GET");

                connect.setRequestProperty("X-RapidAPI-Host", "free-nba.p.rapidapi.com");
                connect.setRequestProperty("X-RapidAPI-Key", "29ad64a363msh8ae2e51447f9aa0p1d99a4jsn6b4186d7e450");

                BufferedReader input = new BufferedReader(
                        new InputStreamReader(connect.getInputStream()));

                String inputLine;
                StringBuffer response = new StringBuffer();

                while ((inputLine = input.readLine()) != null) {
                    response.append(inputLine);
                }
                input.close();

                JsonObject jsonResponse = new Gson().fromJson(response.toString(), JsonObject.class);

                Game[] gameArray = new Gson().fromJson(jsonResponse.get("data").toString(), Game[].class);

                List<Game> games = new ArrayList<>(Arrays.asList(gameArray));

                return games;
        }
        catch (Exception ex) {
            ex.printStackTrace();
            return new ArrayList<>();
        }
    }

}

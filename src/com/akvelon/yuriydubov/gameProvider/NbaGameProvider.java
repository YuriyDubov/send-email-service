package com.akvelon.yuriydubov.gameProvider;

import java.net.HttpURLConnection;
import java.net.URL;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class NbaGameProvider {
    public static StringBuffer getAllGames() {
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

            return response;
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
        return new StringBuffer();
    }
}

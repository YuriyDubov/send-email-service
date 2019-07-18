package com.akvelon.yuriydubov.messageBuilder;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.jtwig.JtwigModel;
import org.jtwig.JtwigTemplate;

import java.util.ArrayList;

public class MessageBuilder {
    public static String render(String pathToTemplate, JtwigModel model) {
        JtwigTemplate template = JtwigTemplate.classpathTemplate(pathToTemplate);
        return template.render(model);
    }
    public static JtwigModel createModelForFirstTemplate(JSONObject json) {
        JSONArray jsonArr = (JSONArray) json.get("data");

        ArrayList<Game> games = new ArrayList<>();
        games.add(new Game("A", "B", 1, 0));
        games.add(new Game("C", "D", 2, 3));

        return JtwigModel.newModel()
                .with("name", "user")
                .with("games", games);
    }
}

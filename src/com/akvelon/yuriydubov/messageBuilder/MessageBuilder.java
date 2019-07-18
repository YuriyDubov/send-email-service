package com.akvelon.yuriydubov.messageBuilder;
import com.akvelon.yuriydubov.gameProvider.Game;

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
        jsonArr.forEach(game -> {
            games.add(new Game((JSONObject) game));
        });
        return JtwigModel.newModel()
                .with("name", "user")
                .with("games", games);
    }
}

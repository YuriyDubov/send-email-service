package com.akvelon.yuriydubov.rendering;
import com.akvelon.yuriydubov.models.Game;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.jtwig.JtwigModel;
import org.jtwig.JtwigTemplate;
import java.util.ArrayList;
import java.util.List;

public class MessageBuilder {
    public static String render(String pathToTemplate, JtwigModel model) {
        JtwigTemplate template = JtwigTemplate.classpathTemplate(pathToTemplate);
        return template.render(model);
    }
    public static JtwigModel createModelForFirstTemplate(List<Game> games) {
        return JtwigModel.newModel()
                .with("name", "user")
                .with("games", games);
    }
}

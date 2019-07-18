package com.akvelon.yuriydubov.messageBuilder;

import org.json.simple.JSONObject;
import org.json.simple.JSONArray;
import org.jtwig.JtwigModel;
import org.jtwig.JtwigTemplate;

public class MessageBuilder {
    public static String render(String pathToTemplate, JtwigModel model) {
        JtwigTemplate template = JtwigTemplate.classpathTemplate(pathToTemplate);
        return template.render(model);
    }
    public static JtwigModel createModelForFirstTemplate(JSONObject json) {
        JSONArray jsonArr = (JSONArray) json.get("data");
        return JtwigModel.newModel().with("name", "user").with("list", jsonArr);
    }
}

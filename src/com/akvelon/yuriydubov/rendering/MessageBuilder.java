package com.akvelon.yuriydubov.rendering;

import com.akvelon.yuriydubov.models.Game;

import com.akvelon.yuriydubov.utils.DateUtils;
import org.jtwig.JtwigModel;
import org.jtwig.JtwigTemplate;
import org.jtwig.environment.EnvironmentConfiguration;
import org.jtwig.environment.EnvironmentConfigurationBuilder;
import org.jtwig.functions.FunctionRequest;
import org.jtwig.functions.SimpleJtwigFunction;

import java.util.Date;
import java.util.List;

public class MessageBuilder {
    public static String render(String pathToTemplate, JtwigModel model) {

        final SimpleJtwigFunction dateToStringConverter = new SimpleJtwigFunction() {
            @Override
            public String name() {
                return "dateToString";
            }

            @Override
            public Object execute(FunctionRequest request) {
                String value = "";
                if (request.getNumberOfArguments() == 1) {
                    if (request.get(0) instanceof Date) {
                        value = DateUtils.toSrting((Date) request.get(0));
                    }
                }
                return value;
            }
        };

        final EnvironmentConfiguration configuration = EnvironmentConfigurationBuilder
                .configuration()
                .functions()
                .add(dateToStringConverter)
                .and()
                .build();

        JtwigTemplate template = JtwigTemplate.classpathTemplate(pathToTemplate, configuration);
        return template.render(model);
    }

    public static JtwigModel createModelForFirstTemplate(List<Game> games) {
        return JtwigModel.newModel()
                .with("name", "user")
                .with("games", games);
    }
}
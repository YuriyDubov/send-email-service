package com.akvelon.yuriydubov;

import com.akvelon.yuriydubov.logging.Logger;
import com.akvelon.yuriydubov.models.Game;
import com.akvelon.yuriydubov.repositories.NbaRepository;
import com.akvelon.yuriydubov.logging.ConsoleLogger;
import com.akvelon.yuriydubov.rendering.MessageBuilder;
import com.akvelon.yuriydubov.senders.EmailMessageSender;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
import org.jtwig.JtwigModel;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Properties;

public class App {

    private static Logger logger;

    public static void main(String[] args) {
        logger = new Logger(new ConsoleLogger());
        logger.log("started...");

        List<Game> gameList = NbaRepository.getAllGames();

        Properties property = new Properties();
        try {
            property.load(App.class.getClassLoader().getResourceAsStream("config.properties"));
            String login = property.getProperty("login");
            String password = property.getProperty("password");
            String recipient = property.getProperty("recipient");

            JtwigModel model = MessageBuilder.createModelForFirstTemplate(gameList);
            String body = MessageBuilder.render("templates/email/game_list_template.twig", model);

            String[] recipients = new String[1];
            recipients[0] = recipient;
            String subject = "Java send mail example";

            logger.log(body);

            EmailMessageSender.send(login, password, recipients, subject, body);

            System.out.println("Goodbye from Main");
        }
        catch (FileNotFoundException ex) {
            System.err.println("File with properties not found");
            ex.printStackTrace();
        }
        catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}

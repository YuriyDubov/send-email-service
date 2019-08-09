package com.akvelon.yuriydubov;

import com.akvelon.yuriydubov.models.Game;
import com.akvelon.yuriydubov.repositories.NbaRepository;
import com.akvelon.yuriydubov.rendering.MessageBuilder;
import com.akvelon.yuriydubov.senders.EmailMessageSender;
import org.apache.logging.log4j.Logger;
import org.jtwig.JtwigModel;

import java.util.List;

import org.apache.logging.log4j.LogManager;

public class App {

    private static final Logger logger = LogManager.getLogger(App.class);

    public static void main(String[] args) {
        logger.info("Start application");

        List<Game> gameList = NbaRepository.getAllGames();

        logger.debug("All games have been received");

        try {
            JtwigModel model = MessageBuilder.createModelForFirstTemplate(gameList);
            String body = MessageBuilder.render("templates/email/game_list_html.twig", model);

            logger.debug("Message body has been built");

            String subject = "Java send mail example";
            EmailMessageSender.send(subject, body);

            logger.info("End");
        } catch (Exception ex) {
            ex.printStackTrace();
            logger.error(ex.getMessage());
            logger.error(ex.getCause());
        }
    }
}
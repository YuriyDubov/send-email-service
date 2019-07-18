package com.akvelon.yuriydubov;

import com.akvelon.yuriydubov.logging.ConsoleLogger;
import com.akvelon.yuriydubov.messageSender.EmailMessageSender;
import com.akvelon.yuriydubov.gameProvider.NbaGameProvider;
import com.akvelon.yuriydubov.messageBuilder.MessageBuilder;

import java.io.*;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import org.jtwig.JtwigModel;
import org.json.simple.*;

public class App {
    public static void main(String[] args) {
        ConsoleLogger.sayHello();

        StringBuffer response = NbaGameProvider.getAllGames();
        System.out.println(response.toString());

        Properties property = new Properties();

        try {
            property.load(App.class.getClassLoader().getResourceAsStream("config.properties"));
            String login = property.getProperty("login");
            String password = property.getProperty("password");
            String recipient = property.getProperty("recipient");

            System.out.println(password);

            JSONObject jsonObject = (JSONObject) JSONValue.parse(response.toString());
            JtwigModel model = MessageBuilder.createModelForFirstTemplate(jsonObject);
            String body = MessageBuilder.render("messageTemplates/firstTemlate.twig", model);

            String[] recipients = new String[1];
            recipients[0] = recipient;
            String subject = "Java send mail example";
            // String body = "Welcome to JavaMail!";

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

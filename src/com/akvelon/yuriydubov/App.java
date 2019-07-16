package com.akvelon.yuriydubov;

import com.akvelon.yuriydubov.logging.ConsoleLogger;
import com.akvelon.yuriydubov.messageSender.EmailMessageSender;
import com.akvelon.yuriydubov.gameProvider.NbaGameProvider;

import org.json.simple.*;
import org.json.simple.parser.JSONParser;
import java.io.FileReader;

public class App {
    public static void main(String[] args) {
        ConsoleLogger.sayHello();

        StringBuffer response = NbaGameProvider.getAllGames();
        System.out.println(response.toString());

        JSONObject json = readConfig();
        String login = (String) json.get("login");
        String password = (String) json.get("password");
        String recipient = (String) json.get("recipient");
        String[] recipients = new String[1];
        recipients[0] = recipient;
        String subject = "Java send mail example";
        String body = "Welcome to JavaMail!";

        EmailMessageSender.send(login, password, recipients, subject, body);

        System.out.println("Goodbye from Main");
    }

    public static JSONObject readConfig() {
        try {
            Object obj = new JSONParser().parse(new FileReader("../../../config.json"));
            return (JSONObject) obj;
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
        return new JSONObject();
    }
}

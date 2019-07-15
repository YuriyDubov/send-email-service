package com.akvelon.yuriydubov;

import com.akvelon.yuriydubov.logging.ConsoleLogger;

import java.util.*;

import javax.mail.*;
import javax.mail.internet.*;

public class App {

    final private static String USER_NAME = "yuriy14dubov@gmail.com";  // GMail user name (just the part before "@gmail.com")
    final private static String PASSWORD = "BrotherMom2591"; // GMail password
    final private static String RECIPIENT = "yurii-dubov@yandex.ru";

    public static void main(String[] args) {
        ConsoleLogger.sayHello();

        String from = USER_NAME;
        String pass = PASSWORD;
        String[] to = {RECIPIENT}; // list of recipient email addresses
        String subject = "Java send mail example";
        String body = "Welcome to JavaMail!";

        sendFromGMail(from, pass, to, subject, body);

        System.out.println("Goodbye from Main");
    }

    private static void sendFromGMail(String from, String pass, String[] to, String subject, String body) {
        Properties props = System.getProperties();
        String host = "smtp.gmail.com";
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", host);
        props.put("mail.smtp.user", from);
        props.put("mail.smtp.password", pass);
        props.put("mail.smtp.port", "587");
        props.put("mail.smtp.auth", "true");

        Session session = Session.getDefaultInstance(props);
        MimeMessage message = new MimeMessage(session);

        try {
            message.setFrom(new InternetAddress(from));
            InternetAddress[] toAddress = new InternetAddress[to.length];

            // To get the array of addresses
            for (int i = 0; i < to.length; i++) {
                toAddress[i] = new InternetAddress(to[i]);
            }

            for (int i = 0; i < toAddress.length; i++) {
                message.addRecipient(Message.RecipientType.TO, toAddress[i]);
            }

            message.setSubject(subject);
            message.setText(body);
            Transport transport = session.getTransport("smtp");
            transport.connect(host, from, pass);
            transport.sendMessage(message, message.getAllRecipients());
            transport.close();
        } catch (AddressException ae) {
            ae.printStackTrace();
        } catch (MessagingException me) {
            me.printStackTrace();
        }
    }

}


//import org.json.simple.*;
//import org.json.simple.parser.JSONParser;
//import java.io.FileReader;
//import EmailMessageSender;

       /* JSONObject json = readConfig();
        String login = (String) json.get("login");
        String password = (String) json.get("password");
        String recipient = (String) json.get("recipient");
        String[] recipients = new String[1];
        recipients[0] = recipient;
        String subject = "Test message";
        String testTex = "It is test message";*/

// EmailMessageSender.send(login, password, recipients, subject, testTex);


/*    public static JSONObject readConfig() {
        try {
            Object obj = new JSONParser().parse(new FileReader("config.json"));
            return (JSONObject) obj;
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
        return new JSONObject();
    }*/


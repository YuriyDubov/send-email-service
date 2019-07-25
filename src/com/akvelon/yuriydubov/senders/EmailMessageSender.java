package com.akvelon.yuriydubov.senders;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;
import java.util.Properties;

public class EmailMessageSender {

    private static String login = "";
    private static String password = "";
    private static List<String> recipients = new ArrayList<>();
    private static final Logger logger = LogManager.getLogger(EmailMessageSender.class);

    public static void send(String subject, String body) {
        logger.debug("Start method for send email");

        EmailMessageSender.initCredentials();
        Properties props = System.getProperties();
        String host = "smtp.gmail.com";
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", host);
        props.put("mail.smtp.user", getLogin());
        props.put("mail.smtp.password", getPassword());
        props.put("mail.smtp.port", "587");
        props.put("mail.smtp.auth", "true");

        Session session = Session.getDefaultInstance(props);

        logger.debug("Was init new session. Details: " + props.toString());

        MimeMessage message = new MimeMessage(session);
        try {
            message.setFrom(new InternetAddress(getLogin()));
            for (String recipient : recipients) {
                InternetAddress toAddress = new InternetAddress((recipient));
                message.addRecipient(Message.RecipientType.TO, toAddress);
            }
            message.setSubject(subject);
            message.setText(body);

            logger.info("Message ready to send");

            Transport transport = session.getTransport("smtp");
            transport.connect(host, getLogin(), getPassword());
            transport.sendMessage(message, message.getAllRecipients());

            logger.debug("Message has been sent");

            transport.close();
        } catch (AddressException ae) {
            ae.printStackTrace();
            logger.error(ae.getMessage());
            logger.error(ae.getCause());
            // TODO: add handler if was an error
        } catch (MessagingException me) {
            me.printStackTrace();
            logger.error(me.getMessage());
            logger.error(me.getCause());
            // TODO: add handler if was an error
        }
    }

    public static void initCredentials () {
        try {
            logger.debug("Start init credentials");
            Properties property = new Properties();
            property.load(EmailMessageSender.class.getClassLoader().getResourceAsStream("config.properties"));

            logger.debug("Config file has been loaded");

            String recipient = property.getProperty("recipient");
            List<String> recipients = new ArrayList<>();
            recipients.add(recipient);

            EmailMessageSender.setRecipients(recipients);
            EmailMessageSender.setLogin(property.getProperty("login"));
            EmailMessageSender.setPassword(property.getProperty("password"));

            logger.debug("Login, password and recipients have been inited");
        } catch (IOException ex) {
            ex.printStackTrace();
            logger.error(ex.getMessage());
            logger.error(ex.getCause());
            // TODO: add handler if was an error
        }
    }

    public static String getLogin() {
        return login;
    }

    public static void setLogin(String login) {
        EmailMessageSender.login = login;
    }

    public static String getPassword() {
        return password;
    }

    public static void setPassword(String password) {
        EmailMessageSender.password = password;
    }

    public static List<String> getRecipients() {
        return recipients;
    }

    public static void setRecipients(List<String> recipients) {
        EmailMessageSender.recipients = recipients;
    }
}


/*
import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;

public class EmailMessageSender {

    public static void send(String from, String pass, String[] to, String subject, String body) {
        Properties props  = System.getProperties();
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
            InternetAddress[] toAdress = new InternetAddress[to.length];

            for( int i = 0; i < to.length; i++) {
                toAdress[i] = new InternetAddress(to[i]);
            }

            for ( int i=0; i < toAdress.length; i++) {
                message.addRecipient(Message.RecipientType.TO, toAdress[i]);
            }

            message.setSubject(subject);
            message.setText(body);

            Transport transport = session.getTransport("smtp");
            transport.connect(host, from, pass);
            transport.sendMessage(message, message.getAllRecipients());
            transport.close();
        }
        catch (AddressException ex) {
            ex.printStackTrace();
        }
        catch (MessagingException ex) {
            ex.printStackTrace();
        }
    }
}
*/

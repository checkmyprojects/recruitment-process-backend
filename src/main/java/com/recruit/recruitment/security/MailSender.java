package com.recruit.recruitment.security;

import javax.mail.*;
import javax.mail.internet.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Properties;

// This class sends a mail to the candidate when the selection process is created
@Component
public class MailSender implements CommandLineRunner
{
    @Value("${mail.password}")
    private String password;

    private static Session session;

    final private static Address from;

    static
    {
        try
        {
            from = new InternetAddress("entityteamf5@outlook.com");
        }
        catch (AddressException e)
        {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void run(String... args)
    {
        Properties p = new Properties();
        p.put("mail.smtp.auth", true);
        p.put("mail.smtp.starttls.enable", "true");
        p.put("mail.smtp.host", "smtp.office365.com");
        p.put("mail.smtp.port", "587");
        p.put("mail.smtp.ssl.trust", "smtp.office365.com");
        session = Session.getInstance(p, new Authenticator()
        {
            @Override
            protected PasswordAuthentication getPasswordAuthentication()
            {
                return new PasswordAuthentication("entityteamf5@outlook.com", password);
            }
        });
    }

    public static void send(String zoomUrl, String email, String position, String candidate, String interviewerName, String interviewerEmail, String interviewDate, String interviewLocation, boolean interviewRemote, String interviewDescription) throws MessagingException
    {
        Message message = new MimeMessage(session);
        message.setSubject("Entrevista para la candidatura a " + position);
        message.setFrom(from);
        message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(email));
        MimeBodyPart body = new MimeBodyPart();
        body.setContent("<h4>Buenas " + candidate +
                ",</h4><br><br><h5>Nos complace anunciar que has sido seleccionado/a para la siguiente candidatura:" +
                "</h5><br><br><ul><li>Posición: " + position + (interviewRemote ? "</li><li>Remoto" : "</li><li>Localidad: " +
                interviewLocation) + "</li><li>Descripción: " + interviewDescription +
                "</li></ul><br><br>Datos del entrevistador/a:<ul><li>Nombre: " + interviewerName + "</li><li>Email: " +
                interviewerEmail + "</li></ul><br><br><h4>Tiene su entrevista el " + interviewDate.replace('T', ' ') +
                "en el siguiente link: " + zoomUrl + "<br><br>Muchas gracias por su participación</h4>", "text/html; charset=utf-8");
        Multipart multipart = new MimeMultipart();
        multipart.addBodyPart(body);
        message.setContent(multipart);
        new Thread(() ->
        {
            try
            {
                Transport.send(message);
            }
            catch (MessagingException e)
            {
                System.out.println(e.getMessage());
            }
        }).start();
    }
}
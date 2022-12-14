package com.example.Servizi.Email2.services;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.stereotype.Service;

import java.io.File;

@Service
public class NotificationService {

    @Autowired
    private JavaMailSender mailSender;


    public void sendTo(String email, String title, String text) throws MessagingException {
        MimeMessage mimeMessage = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, "utf-8");
        String message = "<h1>Git gud!</h1>" +
                "<h2>You have a new message: </h2>" +
                "<img src='https://i.redd.it/f0vtodm2qwe41.jpg' alt='Alternative text' height='200'>" +
                "<h3>" + text + "</h3>";
        helper.setText(message, true);
        helper.setTo(email);
        helper.setSubject(title);
        helper.setFrom("develhope@develhope.co");
        mailSender.send(mimeMessage);
    }



    /*
    public void sendTo(String email, String title, String text, String pathToAttachment) throws MessagingException {
        MimeMessage message = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, true);
        helper.setTo(email);
        helper.setSubject(title);
        helper.setText(text);
        FileSystemResource file = new FileSystemResource(new File(pathToAttachment));
        helper.addAttachment("Invoice", file);

        mailSender.send(message);
    }*/
}

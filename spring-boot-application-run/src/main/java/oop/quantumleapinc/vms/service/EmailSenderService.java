package oop.quantumleapinc.vms.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Service;

@Service
public class EmailSenderService{
    @Autowired
    private org.springframework.mail.javamail.JavaMailSender JavaMailSender;
    public void sendEmail(String toEmail, String subject, String body){
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(toEmail);
        message.setTo(toEmail);
        message.setText(body);
        message.setSubject(subject);
        JavaMailSender.send(message);
        
        System.out.println("Email sent");
    }
}
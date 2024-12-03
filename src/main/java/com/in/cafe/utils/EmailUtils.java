package com.in.cafe.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.util.List;

@Service
public class EmailUtils {

    @Autowired
    private JavaMailSender emailSender;

    public void sendSimpleMessage(String to, String subject, String text, List<String> list){
        SimpleMailMessage mailMessage=new SimpleMailMessage();
        mailMessage.setFrom("guptarohan1411@gmail.com");
        mailMessage.setTo(to);
        mailMessage.setSubject(subject);
        mailMessage.setText(text);
        if (list!=null && list.size()>0)
            mailMessage.setCc(getCcArray(list));

        emailSender.send(mailMessage);

    }

    private String[] getCcArray(List<String> cclist) {

        String[] cc= new String[cclist.size()];
        for (int i=0;i<cclist.size();i++){
            cc[i]=cclist.get(i);
        }

        return cc;
    }

    public void forgotMail(String to, String subject, String password) throws MessagingException {
        MimeMessage message = emailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, true);
        helper.setFrom("guptarohan1411@gmail.com");
        helper.setTo(to);
        helper.setSubject(subject);
        String htmlMessage = "<p><b>Your login details for Cafe Management System" +
                "</b><br><b>Email: </b> " + to + "<br><b>Password: </b> " + password + "<br>" +
                "<a href=\"http://localhost:4200/\"> Click here to login</a></p>";
        message.setContent(htmlMessage, "text/html");
        emailSender.send(message);

    }

}

package com.example.mail.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMailMessage;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;

@Service
public class SendMailService {
    @Autowired
    private JavaMailSender mailSender;
    
    @Value("${spring.mail.username}")
    private String from;


    /**
     * @Author xxx
     * @Description //TODO 发送简单邮件
     * @Date 10:47 2020/6/13
     * @Param [to, subject, text]
     * @return void
     **/
    public void sendMail(String to, String subject, String text) {
    	SimpleMailMessage message =	new SimpleMailMessage();
    	
    	message.setFrom(from);
    	message.setTo(to);
    	message.setSubject(subject);
    	message.setText(text);
    	
    	mailSender.send(message);

    }


    /**
     * @Author xxx
     * @Description //TODO 发送HTML格式带附件的邮件
     * @Date 10:47 2020/6/13
     * @Param [to, subject, text]
     * @return void
     **/
    public void sendAttachMentMail(String to, String subject, String content , File file) {
        MimeMessage message = mailSender.createMimeMessage();
        MimeMessageHelper helper;

        try {
            //true代表支持多组件，如附件，图片等
            helper= new MimeMessageHelper(message, true);
            helper.setFrom(from);
            helper.setTo(to);
            helper.setSubject(subject);
            //true代表支持html
            helper.setText(content, true);
            FileSystemResource filel = new FileSystemResource(file);
            String fileName =filel.getFilename();
            //添加附件，可多次调用该方法添加多个附件
            helper.addAttachment(fileName, filel);
            mailSender.send(message);
        } catch (MessagingException e) {
            e.printStackTrace();
        }

    }

}

package com.anyware.lms.common;

import java.io.UnsupportedEncodingException;

import javax.activation.DataSource;
import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

/**
 * @Date: 2020. 7. 1
 * @FileName : CommonMail.java
 * @Author : dhkim2
 *====================
 * @Description
 *  - 메일 보내기 class
 */
@Component
public class CommonMail 
{
	private static final Logger logger = LoggerFactory.getLogger(CommonMail.class);

    private JavaMailSender mailSender;
    private MimeMessage message;
    private MimeMessageHelper messageHelper;


	public CommonMail(JavaMailSender mailSender) throws MessagingException
	{
		this.mailSender = mailSender;
        message = this.mailSender.createMimeMessage();
        messageHelper = new MimeMessageHelper(message, true, "UTF-8");
	}
    

    public void setSubject(String subject) throws MessagingException {
        messageHelper.setSubject(subject);
    }
    
    public void setText(String htmlContent) throws MessagingException {
        messageHelper.setText(htmlContent, true);
    }
    
    public void setFrom(String email, String name) throws UnsupportedEncodingException, MessagingException {
        messageHelper.setFrom(email, name);
    }
    
    public void setTo(String email) throws MessagingException {
        messageHelper.setTo(email);
    }
    
    public void addInline(String contentId, DataSource dataSource) throws MessagingException {
        messageHelper.addInline(contentId, dataSource);
    }
    
    public void send() {
        mailSender.send(message);
    }
}

package com.nus.travel_website.util;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;
public final class MailUtils {
    private static final String USER = "Xuejing.Chen.1998@gmail.com"; // sender
    private static final String PASSWORD = "kydb nvnq blxi wvgl";

    /**
     * @param to ：receiver
     * @param text ：email content
     * @param title ：email title
     */
    public static boolean sendMail(String to, String text, String title){
        try {
            final Properties props = new Properties();
            props.put("mail.smtp.host", "smtp.gmail.com");
            props.put("mail.smtp.port", "587");
            props.put("mail.smtp.auth", "true");
            props.put("mail.smtp.starttls.enable", "true"); //TLS

            props.put("mail.user", USER);
            props.put("mail.password", PASSWORD);

            // authenticate the username and password
            Authenticator authenticator = new Authenticator() {
                @Override
                protected PasswordAuthentication getPasswordAuthentication() {
                    String userName = props.getProperty("mail.user");
                    String password = props.getProperty("mail.password");
                    return new PasswordAuthentication(userName, password);
                }
            };
            // create the session object
            Session mailSession = Session.getInstance(props, authenticator);

            // compose the message
            MimeMessage message = new MimeMessage(mailSession);

            // set sender
            String username = props.getProperty("mail.user");
            InternetAddress form = new InternetAddress(username);
            message.setFrom(form);

            // set receiver
            InternetAddress toAddress = new InternetAddress(to);
            message.setRecipient(Message.RecipientType.TO, toAddress);

            // set email title
            message.setSubject(title);

            // set email content
            message.setContent(text, "text/html");
            // sent the email
            Transport.send(message);
            return true;
        }catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }

    public static void main(String[] args) throws Exception { // 做测试用
        MailUtils.sendMail("xuejingcc@gmail.com","hi,this is a test email","text email");
        System.out.println("发送成功");
    }
}

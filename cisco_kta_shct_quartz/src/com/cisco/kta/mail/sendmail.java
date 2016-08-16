package com.cisco.kta.mail;

import java.io.InputStream;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeUtility;

public class sendmail {
	 private MimeMessage message;
	 private Session session;
	 private Transport transport;
	 
	 private String host;
	 private String username;
	 private String password;
	 private Properties properties = new Properties();
	 
	 public sendmail(){
		 InputStream propertyfile = this.getClass().getClassLoader().getResourceAsStream("mail.properties");
		 try {
	            properties.load(propertyfile);
	            this.host = properties.getProperty("mail.smtp.host");
	            this.username = properties.getProperty("mail.sender.username");
	            this.password = properties.getProperty("mail.sender.password");
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	        
	        session = Session.getInstance(properties);
	        message = new MimeMessage(session);
	 }
	 public void doSendHtmlEmail(String subject, String sendHtml,String receiveUser){
		 
		try {
			InternetAddress from = new InternetAddress(MimeUtility.encodeWord("kta_chenfei")+" <"+this.username+">");
			message.setFrom(from);
			InternetAddress[] to = new InternetAddress().parse(receiveUser);
            message.setRecipients(Message.RecipientType.TO, to);
            message.setSubject(subject);
            String content = sendHtml.toString();
            message.setContent(content, "text/html;charset=UTF-8"); 
            message.saveChanges();
           
            transport = session.getTransport("smtp");
            transport.connect(this.host, this.username, this.password);
            transport.sendMessage(message, message.getAllRecipients());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
            if(transport!=null){
                try {
                    transport.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
	 }
/*	 public static void main(String args[]){
		 sendmail sm = new sendmail();
		 sm.doSendHtmlEmail("test", "hello", "feic@cisco.com,chen_xfei@me.com");
		 System.out.println("mail send out");
	 }
*/

}

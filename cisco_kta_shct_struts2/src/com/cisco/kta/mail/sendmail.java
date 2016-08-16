package com.cisco.kta.mail;

import java.io.File;
import java.io.InputStream;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
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
			InternetAddress to = new InternetAddress(receiveUser);
            message.setRecipient(Message.RecipientType.TO, to);
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
	 public String doSendAttachedEmail(String subject, String sendHtml,String receiveUser,File attachment){
		 
		try {
			InternetAddress from = new InternetAddress(MimeUtility.encodeWord("kta_chenfei")+" <"+this.username+">");
			message.setFrom(from);
			InternetAddress to = new InternetAddress(receiveUser);
            message.setRecipient(Message.RecipientType.TO, to);
            message.setSubject(subject);
            Multipart multipart = new MimeMultipart();
            BodyPart contentPart = new MimeBodyPart();
            contentPart.setContent(sendHtml, "text/html;charset=UTF-8");
            multipart.addBodyPart(contentPart);
            if (attachment != null) {
                BodyPart attachmentBodyPart = new MimeBodyPart();
                DataSource source = new FileDataSource(attachment);
                attachmentBodyPart.setDataHandler(new DataHandler(source));
                attachmentBodyPart.setFileName(MimeUtility.encodeWord(attachment.getName()));
                multipart.addBodyPart(attachmentBodyPart);
            }
            message.setContent(multipart);
            message.saveChanges();
            transport = session.getTransport("smtp");
            transport.connect(this.host, this.username, this.password);
            transport.sendMessage(message, message.getAllRecipients());
            return "success";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "error";
		}
         
		 
	 }
/*	 public static void main(String args[]){
		 sendmail sm = new sendmail();
		 File attach = new File("/root/quartz_jobs.xml");
		 for (int i = 0; i <3 ; i++){
			 if (sm.doSendAttachedEmail("test", "hello", "feic@cisco.com", attach).equals("success")){
				 break;
			 }
		 }
		 System.out.println("mail send out");
	 }
*/	 

}

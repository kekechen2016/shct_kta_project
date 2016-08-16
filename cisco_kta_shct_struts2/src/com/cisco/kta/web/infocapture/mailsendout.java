package com.cisco.kta.web.infocapture;

import java.io.File;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.cisco.kta.mail.sendmail;
import com.opensymphony.xwork2.ActionSupport;

public class mailsendout extends ActionSupport{
	String receiver;
	String text;
	String filename;
	public String execute(){
		try{
			File f = new File("filename");
			sendmail sm = new sendmail();
			String content = "<html><body>information capture</body></html>";
			sm.doSendAttachedEmail("shct informaton collection -" + filename, content , receiver, f);
			f.delete();
		}catch(Exception e){
			e.printStackTrace();
		}
		return SUCCESS;
	}
	public void setReceiver(String receiver) {
		this.receiver = receiver;
	}
	public void setText(String text) {
		this.text = text;
	}
	public void setFilename(String filename) {
		this.filename = filename;
	}
	
	
	
	

}

	
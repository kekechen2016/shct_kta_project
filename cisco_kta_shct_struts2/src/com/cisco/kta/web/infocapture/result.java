package com.cisco.kta.web.infocapture;

import java.io.File;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.JSONObject;

import com.opensymphony.xwork2.ActionSupport;
import com.cisco.kta.shct.xde.XdeControl;
import com.cisco.kta.shct.xde.XdeFunction;
import com.cisco.nm.workflow.client.XDEException;

public class result extends ActionSupport{
	private Map infocapture = new HashMap();
	private String defaultcli;
	private String cli;
	private String device;
	private String filename;
	public String execute(){
		List<String> list = new ArrayList<String>();
		if (!defaultcli.isEmpty()){
			String[] dfclist = this.defaultcli.split("\r\n");
			for (String i : dfclist){
				list.add(i);
			}
		}
		if (!cli.isEmpty()){
			String[] clist = this.cli.split("\r\n");
			for (String i : clist){
				list.add(i);
			}
		}
		String[] L = new String[list.size()];
		list.toArray(L);
		String xdecommand = XdeFunction.xdeCommandList(L);		
		
		try {
			String [] paramlist = new String[2];
			paramlist[0] = this.device;
			paramlist[1] = xdecommand;
			XdeControl.init("/root/xdeRuntime");
			XdeControl xde = new XdeControl("shct_info_capture","procedure",paramlist);
			if(xde.isError()){
				return ERROR;
			}
			JSONObject JSONObject = xde.getJSONObject();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd-HHmmss");
			filename = device +"-" + sdf.format(new Date());
			File f = new File("filename");
			if(!f.exists()){
				f.createNewFile();
			}
			FileOutputStream fos = null;
			fos = new FileOutputStream(f);
			
			for (String str: L){
				infocapture.put(str, JSONObject.getString(str));
				String text = str + "\r\n" + JSONObject.getString(str);
				fos.write(text.getBytes());
			}
			fos.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return SUCCESS;
	}
	
	public void setDevice(String device) {
		this.device = device;
	}

	public void setDefaultcli(String defaultcli) {
		this.defaultcli = defaultcli;
	}
	public void setCli(String cli) {
		this.cli = cli;
	}

	public Map getInfocapture() {
		return infocapture;
	}

	public String getFilename() {
		return filename;
	}
	

}

package com.cisco.kta.web.transceiverpower;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONObject;

import com.cisco.kta.shct.xde.XdeControl;
import com.cisco.nm.workflow.client.XDEException;
import com.opensymphony.xwork2.ActionSupport;

public class result extends ActionSupport{
	private String[] paramlist = new String[3];
	private String device;
	private String porttype;
	private String portnumber;
	private Map Transceiverpower = new HashMap();

	public String execute(){
		try {
			paramlist[0] = this.device;
			paramlist[1] = this.porttype;
			paramlist[2] = this.portnumber;
			XdeControl.init("/root/xdeRuntime");
			XdeControl xde = new XdeControl("shct_iosxr_transceiver_power","procedure",paramlist);
			if(xde.isError()){
				return ERROR;
			}
			JSONObject JSONObject = xde.getJSONObject();
			Transceiverpower.put("pid", JSONObject.getString("pid"));
			Transceiverpower.put("sn", JSONObject.getString("sn"));
			Transceiverpower.put("txpower", JSONObject.get("txpower").toString());
			Transceiverpower.put("rxpower", JSONObject.get("rxpower").toString()); 
			XMLRead xmlread = new XMLRead("/root/webserver/apache-tomcat-8.0.32/webapps/cisco_kta_shct_struts2/WEB-INF/classes/transceivers.rxpower",JSONObject.getString("pid"));
			Transceiverpower.put("minrxpower", xmlread.getMinpower());
			Transceiverpower.put("maxrxpower", xmlread.getMaxpower());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return SUCCESS;
	}
	
	public void setDevice(String device) {
		this.device = device;
	}
	public void setPorttype(String porttype) {
		this.porttype = porttype;
	}
	public void setPortnumber(String portnumber) {
		this.portnumber = portnumber;
	}
	public Map getTransceiverpower() {
		return Transceiverpower;
	}

}

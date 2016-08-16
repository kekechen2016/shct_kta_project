package com.cisco.kta.web.netdr;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONObject;

import com.cisco.kta.shct.xde.XdeControl;
import com.opensymphony.xwork2.ActionSupport;

public class result extends ActionSupport{
	private String device;
	private List<Map<String, String>> mlist = new ArrayList<Map<String, String>>();
	private Map<String, Integer> ifmap = new HashMap();

	public String execute(){
		String[] paramlist = new String[1];
		paramlist[0] = this.device;
		try {
			XdeControl.init("/root/xdeRuntime");
			XdeControl xde = new XdeControl("7609_netdr_capture","procedure",paramlist);
			if(xde.isError()){
				return ERROR;
			}
			JSONArray JSONArray = xde.toJSONArray();
			 for (int i = 0; i < JSONArray.length(); i++) {
				 HashMap map = new HashMap();
				 JSONObject jobject = JSONArray.getJSONObject(i);
				 String ifname = jobject.getString("interface");
				 if (ifmap.containsKey(ifname)){
					 ifmap.replace(ifname, (Integer)ifmap.get(ifname)+1);
				 }else{
					 ifmap.put(ifname, (Integer)1);
				 } 
				 map.put("ifname", ifname);
				 map.put("destmac", jobject.getString("destmac"));
				 map.put("srcmac", jobject.getString("srcmac"));
				 map.put("l3protocol", jobject.getString("l3protocol"));
				 if (jobject.getString("l3protocol").equals("0800")){
					 map.put("ttl", jobject.getString("ttl"));
					 map.put("srcip", jobject.getString("srcip"));
					 map.put("dstip", jobject.getString("dstip"));
					 map.put("l4protocol", jobject.getString("l4protocol"));
					 map.put("srcport", jobject.getString("srcport"));
					 map.put("dstport", jobject.getString("dstport"));
				 }
				 this.mlist.add(map);

			 }
			 
		} catch (Exception e) {
			// TODO Auto-generated catch block
		}
		return SUCCESS;		
	}

	public Map<String, Integer> getIfmap() {
		return ifmap;
	}

	public void setDevice(String device) {
		this.device = device;
	}

	public List<Map<String, String>> getMlist() {
		return mlist;
	}
	

}

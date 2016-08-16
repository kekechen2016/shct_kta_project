package com.cisco.kta.web.asr9kunicastflooding;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.cisco.kta.shct.database.handler.asr9kUnicastFloodingDBHandler;
import com.cisco.kta.shct.database.model.asr9kUnicastFloodingDto;
import com.cisco.kta.shct.inventory.handler.InventoryList;
import com.opensymphony.xwork2.ActionSupport;

public class listbydate extends ActionSupport{
	String device;
	String date;
	private List<asr9kUnicastFloodingDto> asr9kUnicastFloodingDtoList;
	private List<Map<String,String>> inventories = new ArrayList<Map<String,String>>();
	
	public String execute() {
		try{
			InventoryList InventoryList = new InventoryList();
			this.inventories = InventoryList.inventoryXMLRead("/root/xdeRuntime/conf/inventory.properties");
			asr9kUnicastFloodingDBHandler asr9kUnicastFloodingDBHandler = new asr9kUnicastFloodingDBHandler();
			if (this.device.equals("all")){
				asr9kUnicastFloodingDtoList = asr9kUnicastFloodingDBHandler.selectAllByDate(this.date);
			}else{
				asr9kUnicastFloodingDtoList = asr9kUnicastFloodingDBHandler.selectByDeviceByDate(this.device, this.date);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return SUCCESS;
	}

	public List<asr9kUnicastFloodingDto> getAsr9kUnicastFloodingDtoList() {
		return asr9kUnicastFloodingDtoList;
	}
	

	public List<Map<String, String>> getInventories() {
		return inventories;
	}

	public void setDevice(String device) {
		this.device = device;
	}

	public void setDate(String date) {
		this.date = date;
	}
	
}

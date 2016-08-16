package com.cisco.kta.web.asr9kunicastflooding;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Map;

import com.cisco.kta.shct.database.handler.asr9kUnicastFloodingDBHandler;
import com.cisco.kta.shct.database.model.asr9kUnicastFloodingDto;
import com.cisco.kta.shct.inventory.handler.InventoryList;
import com.opensymphony.xwork2.ActionSupport;

public class listtoday extends ActionSupport{
	private List<asr9kUnicastFloodingDto> asr9kUnicastFloodingDtoList;
	private List<Map<String,String>> inventories = new ArrayList<Map<String,String>>();
	
	public String execute() {
		try{
			InventoryList InventoryList = new InventoryList();
			this.inventories = InventoryList.inventoryXMLRead("/root/xdeRuntime/conf/inventory.properties");		
			asr9kUnicastFloodingDBHandler asr9kUnicastFloodingDBHandler = new asr9kUnicastFloodingDBHandler();
			asr9kUnicastFloodingDtoList = asr9kUnicastFloodingDBHandler.selectAllToday();
			if (asr9kUnicastFloodingDtoList.isEmpty()){
				Calendar   cal   =   Calendar.getInstance();
				cal.add(Calendar.DATE,-1);
				String date = new SimpleDateFormat( "yyyy-MM-dd ").format(cal.getTime());
				asr9kUnicastFloodingDtoList = asr9kUnicastFloodingDBHandler.selectAllByDate(date);
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
	

	
	
	

}

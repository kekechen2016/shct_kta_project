package com.cisco.kta.web.netdr;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.cisco.kta.shct.inventory.handler.InventoryList;
import com.opensymphony.xwork2.ActionSupport;

public class form extends ActionSupport{
	private List<Map<String,String>> inventories = new ArrayList<Map<String,String>>();

	public String execute(){
		InventoryList InventoryList = new InventoryList();
		try {
			inventories = InventoryList.inventoryXMLRead("/root/xdeRuntime/conf/inventory.properties");			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return SUCCESS;
	}
	public List<Map<String, String>> getInventories() {
		return inventories;
	}

}
package com.cisco.kta.shct.inventory.handler;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import com.opensymphony.xwork2.ActionSupport;

public class InventoryList extends ActionSupport{
	private List<Map<String,String>> inventories = new ArrayList<Map<String,String>>();

	public String execute() throws Exception{
		inventories = inventoryXMLRead("/root/xdeRuntime/conf/inventory.properties");
		return SUCCESS;
	}
	
	public List<Map<String,String>> inventoryXMLRead(String file) throws Exception{
		List<Map<String,String>> result = new ArrayList<Map<String,String>>();
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = factory.newDocumentBuilder();
		Document doc = builder.parse(file);		
		NodeList nlist = doc.getElementsByTagName("device");
		for (int i = 0 ; i < nlist.getLength() ; i++){
			Map<String,String> m = new HashMap<String,String>();
			Element node = (Element)nlist.item(i);
			m.put("Devicename", node.getAttribute("id"));
			m.put("IP_Address", node.getElementsByTagName("CLI_ADDRESS").item(0).getFirstChild().getNodeValue());
			m.put("Login_Username", node.getElementsByTagName("CLI_LOGIN_USERNAME").item(0).getFirstChild().getNodeValue());
			m.put("Login_Password", node.getElementsByTagName("CLI_LOGIN_PASSWORD").item(0).getFirstChild().getNodeValue());
			result.add(m);
		}
		
		return result;
		
	}
	public List<Map<String,String>> getInventories() {
		return inventories;
	}

	public void setInventories(List<Map<String,String>> inventories) {
		this.inventories = inventories;
	}

}

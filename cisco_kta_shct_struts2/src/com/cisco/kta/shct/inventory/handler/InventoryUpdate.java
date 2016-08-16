package com.cisco.kta.shct.inventory.handler;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import com.opensymphony.xwork2.ActionSupport;

public class InventoryUpdate extends ActionSupport{
	private String username;
	private String password;
	
	public String execute(){
		try {
			inventoryXMLUpdate("/root/xdeRuntime/conf/inventory.properties");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return SUCCESS;
	}
	
	public void inventoryXMLUpdate(String filePath) throws Exception{
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = factory.newDocumentBuilder();
		Document doc = builder.parse(filePath);		
		NodeList nlist = doc.getElementsByTagName("device");
		for (int i = 0 ; i < nlist.getLength() ; i++){
			Element node = (Element)nlist.item(i);
			if (!this.username.isEmpty()){
				node.getElementsByTagName("CLI_LOGIN_USERNAME").item(0).getFirstChild().setNodeValue(this.username);
				}
				node.getElementsByTagName("CLI_LOGIN_PASSWORD").item(0).getFirstChild().setNodeValue(this.password);
			
		}
		saveXML(doc, filePath);
		
	}
	public static boolean saveXML(Document document, String filePath){
        try{
            TransformerFactory tFactory = TransformerFactory.newInstance();
            Transformer transformer = tFactory.newTransformer();
            
            DOMSource source = new DOMSource(document);
            StreamResult result = new StreamResult(new File(filePath));
            transformer.transform(source, result);
            System.out.println("update finished");
            return true;
        }catch(Exception e){
            e.printStackTrace();
            System.out.println(e.getMessage());
            return false;
        }
    }
		
	public void setPassword(String password) {
		this.password = password;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	

}

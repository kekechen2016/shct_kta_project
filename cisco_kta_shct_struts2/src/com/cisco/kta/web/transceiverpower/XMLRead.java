package com.cisco.kta.web.transceiverpower;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

public class XMLRead {
	String minpower;
	String maxpower;
	public XMLRead(String file,String pid){
		try {
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder;
			builder = factory.newDocumentBuilder();
			Document doc = builder.parse(file);		
			NodeList nlist = doc.getElementsByTagName("pid");
			for (int i = 0 ; i < nlist.getLength() ; i++){
				Element node = (Element)nlist.item(i);
				if (node.getAttribute("id").equals(pid)){
					this.minpower = node.getElementsByTagName("minrxpower").item(0).getFirstChild().getNodeValue();
					this.maxpower = node.getElementsByTagName("maxrxpower").item(0).getFirstChild().getNodeValue();
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public String getMinpower() {
		return minpower;
	}
	public String getMaxpower() {
		return maxpower;
	}

}

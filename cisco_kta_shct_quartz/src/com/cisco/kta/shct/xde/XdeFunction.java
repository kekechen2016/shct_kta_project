package com.cisco.kta.shct.xde;

import java.util.ArrayList;

public class XdeFunction {
	public static String[] StringToList(String str){
		String[] i = str.split("%");
		ArrayList<String> arraylist = new ArrayList<String>();
		StringBuilder sb = new StringBuilder();
		String[] list1 = i[0].split(",");
		if (list1.length == 1){
			arraylist.add(list1[0]);
		}else{
			sb.append("<list>");
			for (String j : list1){
				sb.append("<item type=\"STRING\">");
				sb.append(j);
				sb.append("</item>");
			}
			sb.append("</list>");
			arraylist.add(sb.toString());
		}
		
		if (i.length == 2){
			sb = new StringBuilder();
			String[] list2 = i[1].split(",");
			sb.append("<execCmdConv>");
			for (String k : list2){
				sb.append("<cliConv formatVersion=\"1\"><send>");
				sb.append(k);
				sb.append("</send></cliConv>");
			}
			sb.append("</execCmdConv>");
			arraylist.add(sb.toString());
		}
		String[] L = new String[arraylist.size()];
		arraylist.toArray(L);
		return L;
	}
	
	
	
	public static String xdeCommandList(String[] list){
		StringBuilder sb = new StringBuilder();
		sb.append("<execCmdConv>");
		for (String l : list){
			sb.append("<cliConv formatVersion=\"1\"><send>");
			sb.append(l);
			sb.append("</send></cliConv>");
		}
		sb.append("</execCmdConv>");
		return sb.toString();
	}

}

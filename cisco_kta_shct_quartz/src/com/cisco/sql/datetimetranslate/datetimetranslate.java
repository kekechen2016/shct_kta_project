package com.cisco.sql.datetimetranslate;

import java.text.ParseException;
import java.text.SimpleDateFormat;

public class datetimetranslate {
	private java.sql.Timestamp sqldatetime;
	
	public datetimetranslate(String time){
		String[] MONTH = {
			    "Jan","Feb","Mar","Apr","May","Jun",
			    "Jul","Aug","Sep","Oct","Nov","Dec", 
			  };
		
		StringBuilder sb = new StringBuilder();
		
		sb.append(time.substring(11,11+4));
		for (int i = 0;i<12;i++){
			if(time.substring(4,4+3).equals(MONTH[i])){
				 if((i+1) < 10)
				     sb.append("-0");
				    else
				     sb.append("-");
				    sb.append((i+1));
			}
		}
		sb.append("-");
		sb.append(time.substring(8,8+2));
		
		sb.append(" ");
		sb.append(time.substring(16,16+8));
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		try {
			java.util.Date d1 = sdf.parse(sb.toString());
		    sqldatetime = new java.sql.Timestamp(d1.getTime());
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
	}
	public java.sql.Timestamp getSqldatetime() {
		return sqldatetime;
	}
	

}

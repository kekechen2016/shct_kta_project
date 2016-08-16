package com.cisco.kta.shct.asr9kcefusage;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.json.JSONArray;
import org.json.JSONObject;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import com.cisco.kta.shct.xde.XdeFunction;
import com.cisco.sql.datetimetranslate.datetimetranslate;
import com.cisco.kta.mail.sendmail;
import com.cisco.kta.shct.database.handler.asr9kCefUsageDBHandler;
import com.cisco.kta.shct.database.model.asr9kCefUsageDto;
import com.cisco.kta.shct.xde.XdeControl;


public class asr9kcefusage implements Job{
	private static Logger logger = Logger.getLogger(asr9kcefusage.class);

	@Override
	public void execute(JobExecutionContext context) throws JobExecutionException {
		// TODO Auto-generated method stub
		  	
		String packageID = context.getJobDetail().getJobDataMap().getString("packageID");
		String functionName = context.getJobDetail().getJobDataMap().getString("functionName");
		String paramStrings = context.getJobDetail().getJobDataMap().getString("paramStrings");
		String [] para = XdeFunction.StringToList(paramStrings);
		try {
			List<asr9kCefUsageDto> warninglist = new ArrayList<asr9kCefUsageDto>();
			XdeControl xde = new XdeControl(packageID,functionName,para);
			if (xde.isError()){
				return;
			}
			asr9kCefUsageDBHandler asr9kCefUsageDBHandler = new asr9kCefUsageDBHandler();
			JSONArray jsonarray = xde.toJSONArray();
			 for (int i = 0; i < jsonarray.length(); i++) {
				JSONObject jobject = jsonarray.getJSONObject(i);
			    String device = jobject.getString("device");
			    datetimetranslate dtt= new datetimetranslate(jobject.get("datetime").toString());
			    java.sql.Timestamp datetime = dtt.getSqldatetime();
			    JSONArray valuejsonarry = new JSONArray(jobject.get("value").toString());
			    for (int j = 0; j < valuejsonarry.length(); j++){
			    	asr9kCefUsageDto asr9kCefUsageDto = new asr9kCefUsageDto();	
			    	JSONObject valuejobject = valuejsonarry.getJSONObject(j);
			    	asr9kCefUsageDto.setDevice(device);
			    	asr9kCefUsageDto.setSlot(valuejobject.get("slot").toString());
			    	asr9kCefUsageDto.setUsed(valuejobject.getString("usage"));
			    	asr9kCefUsageDto.setMax(valuejobject.getString("max"));
			    	asr9kCefUsageDto.setPercent(valuejobject.getString("percent"));
			    	asr9kCefUsageDto.setDatetime(datetime);
			    	asr9kCefUsageDBHandler.insert(asr9kCefUsageDto);
			    	if (Integer.parseInt(valuejobject.getString("percent").substring(0, 2)) < 70){
			    		warninglist.add(asr9kCefUsageDto);
			    	}
			    }
			}
			if (!warninglist.isEmpty()){
				StringBuilder sb = new StringBuilder();
				sb.append("<html><head></head><body><table><tr><td>device name</td><td>slot</td><td>used</td><td>max</td><td>percent</td><td>datetime</td></tr>");
				for (asr9kCefUsageDto i : warninglist){
					sb.append("<tr>");
					sb.append("<td>" + i.getDevice() + "</td>" + "<td>" + i.getSlot() + "</td>" + "<td>" + i.getUsed() + "</td>" + "<td>" + i.getMax() + "</td>"
							+ "<td>" + i.getPercent() + "</td>" + "<td>" + i.getDatetime() + "</td>");
					sb.append("</tr>");
				}
				sb.append("</table></body></html>");
				sendmail sm = new sendmail();
				sm.doSendHtmlEmail("shct asr9k cef resource warning", sb.toString(), "feic@cisco.com");
				
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			logger.info(e.getMessage(),e);
		} 
	}
	

}

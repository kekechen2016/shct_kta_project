package com.cisco.kta.shct.asr9kunicastflooding;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.json.JSONArray;
import org.json.JSONObject;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import com.cisco.kta.mail.sendmail;
import com.cisco.kta.shct.database.handler.asr9kUnicastFloodingDBHandler;
import com.cisco.kta.shct.database.model.asr9kUnicastFloodingDto;
import com.cisco.kta.shct.xde.XdeControl;
import com.cisco.kta.shct.xde.XdeFunction;
import com.cisco.sql.datetimetranslate.datetimetranslate;


public class asr9kunicastfloodingcapture implements Job{
	private static Logger logger = Logger.getLogger(asr9kunicastfloodingcapture.class);
	public void execute(JobExecutionContext context) throws JobExecutionException {
		String packageID = context.getJobDetail().getJobDataMap().getString("packageID");
		String functionName = context.getJobDetail().getJobDataMap().getString("functionName");
		String paramStrings = context.getJobDetail().getJobDataMap().getString("paramStrings");
		String [] para = XdeFunction.StringToList(paramStrings);
		try {
			List<asr9kUnicastFloodingDto> warningList = new ArrayList<asr9kUnicastFloodingDto>();
			XdeControl xde = new XdeControl(packageID,functionName,para);
			if (xde.isError()){
				return;
			}
			asr9kUnicastFloodingDBHandler asr9kUnicastFloodingDBHandler = new asr9kUnicastFloodingDBHandler();
			JSONArray jsonarray = xde.toJSONArray();
			System.out.println(jsonarray.toString());
			for (int i = 0; i < jsonarray.length(); i++){
				asr9kUnicastFloodingDto asr9kUnicastFloodingDto = new asr9kUnicastFloodingDto();
				JSONObject jobject = jsonarray.getJSONObject(i);
				asr9kUnicastFloodingDto.setDevice(jobject.getString("device"));
				asr9kUnicastFloodingDto.setPort(jobject.getString("port"));
				if (jobject.get("bytes").equals("")){
					asr9kUnicastFloodingDto.setBytes(0);
				}else{
					asr9kUnicastFloodingDto.setBytes(jobject.getInt("bytes"));	
				}
				if (jobject.get("packets").equals("")){
					asr9kUnicastFloodingDto.setPackets(0);
				}else{
					asr9kUnicastFloodingDto.setPackets(jobject.getInt("packets"));
				}
				if (jobject.get("avg").equals(null)){
					asr9kUnicastFloodingDto.setAvg(0);
				}else{
					asr9kUnicastFloodingDto.setAvg(jobject.getInt("avg"));
				}
				datetimetranslate dtt= new datetimetranslate(jobject.get("datetime").toString());
			    java.sql.Timestamp datetime = dtt.getSqldatetime();
				asr9kUnicastFloodingDto.setDatetime(datetime);
				asr9kUnicastFloodingDBHandler.insert(asr9kUnicastFloodingDto);
				if (asr9kUnicastFloodingDto.getAvg() > 500){
					warningList.add(asr9kUnicastFloodingDto);
				}
			}
			if (!warningList.isEmpty()){
				StringBuilder sb = new StringBuilder();
				sb.append("<html><head></head><body><table><tr><td>device name</td><td>port</td><td>bytes</td><td>packets</td><td>avg</td><td>datetime</td></tr>");
				for (asr9kUnicastFloodingDto i : warningList){
					sb.append("<tr>");
					sb.append("<td>" + i.getDevice() + "</td>" + "<td>" + i.getPort() + "</td>" + "<td>" + i.getBytes() + "</td>" + "<td>" + i.getPackets() + "</td>"
							+ "<td>" + i.getAvg() + "</td>" + "<td>" + i.getDatetime() + "</td>");
					sb.append("</tr>");
				}
				sb.append("</table></body></html>");
				sendmail sm = new sendmail();
				sm.doSendHtmlEmail("List of asr9k suspected unicast flooding ports", sb.toString(), "feic@cisco.com");
				
			}
			
		}catch (Exception e) {
			// TODO Auto-generated catch block
			logger.info(e.getMessage(),e);
		} 
	}

}

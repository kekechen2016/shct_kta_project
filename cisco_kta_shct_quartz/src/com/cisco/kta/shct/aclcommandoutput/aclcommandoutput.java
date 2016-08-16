package com.cisco.kta.shct.aclcommandoutput;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;

import org.apache.log4j.Logger;
import org.json.JSONObject;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import com.cisco.kta.shct.database.handler.aclCommandOutputDBHandler;
import com.cisco.kta.shct.database.model.aclCommandOutputDto;
import com.cisco.kta.shct.xde.XdeControl;
import com.cisco.kta.shct.xde.XdeFunction;


public class aclcommandoutput implements Job{
	private static Logger logger = Logger.getLogger(aclcommandoutput.class);
	public void execute(JobExecutionContext context) throws JobExecutionException {
		String packageID = context.getJobDetail().getJobDataMap().getString("packageID");
		String functionName = context.getJobDetail().getJobDataMap().getString("functionName");
		String paramStrings = context.getJobDetail().getJobDataMap().getString("paramStrings");
		String [] para = XdeFunction.StringToList(paramStrings);
		try{
			XdeControl xde = new XdeControl(packageID,functionName,para);
			if (xde.isError()){
				return;
			}
			JSONObject JSONObject = xde.getJSONObject();
			Iterator<String> iter = JSONObject.keys();
			while(iter.hasNext()){
				aclCommandOutputDBHandler aclCommandOutputDBHandler = new aclCommandOutputDBHandler();
				aclCommandOutputDto aclCommandOutputDto = new aclCommandOutputDto();
				aclCommandOutputDto.setDevice(para[0]);
				String command = iter.next();
				aclCommandOutputDto.setCommand(command);
				aclCommandOutputDto.setOuput(JSONObject.getString(command));
				aclCommandOutputDto.setDatetime(nowmyslqtime());
				aclCommandOutputDBHandler.insert(aclCommandOutputDto);
			}			
			
		}catch(Exception e){
			logger.info(e.getMessage(),e);
		}
	}
	public Timestamp nowmyslqtime(){
		Date date = new Date();
		String nowTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date);
		Timestamp datetime = Timestamp.valueOf(nowTime);
		return datetime;
	}
}

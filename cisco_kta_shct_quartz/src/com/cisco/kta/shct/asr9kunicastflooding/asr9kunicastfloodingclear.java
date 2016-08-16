package com.cisco.kta.shct.asr9kunicastflooding;


import org.apache.log4j.Logger;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;


import com.cisco.kta.shct.xde.XdeControl;
import com.cisco.kta.shct.xde.XdeFunction;

public class asr9kunicastfloodingclear implements Job{
	private static Logger logger = Logger.getLogger(asr9kunicastfloodingclear.class);
	public void execute(JobExecutionContext context) throws JobExecutionException {
		String packageID = context.getJobDetail().getJobDataMap().getString("packageID");
		String functionName = context.getJobDetail().getJobDataMap().getString("functionName");
		String paramStrings = context.getJobDetail().getJobDataMap().getString("paramStrings");
		String [] para = XdeFunction.StringToList(paramStrings);
		try {
			XdeControl xde = new XdeControl(packageID,functionName,para);
			if (xde.isError()){
				return;
			}			
		}catch (Exception e) {
			// TODO Auto-generated catch block
			logger.info(e.getMessage(),e);
		} 

			
	}

}

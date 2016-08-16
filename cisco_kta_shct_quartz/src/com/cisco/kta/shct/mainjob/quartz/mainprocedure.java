package com.cisco.kta.shct.mainjob.quartz;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.quartz.Scheduler;
import org.quartz.SchedulerFactory;
import org.quartz.impl.StdSchedulerFactory;

import com.cisco.kta.shct.xde.XdeControl;

public class mainprocedure {
	private static Logger logger = Logger.getLogger(mainprocedure.class);
	public static void main(String[] args){
		PropertyConfigurator.configure( "log4j.properties" );
		try {
			XdeControl.init("/root/xdeRuntime");
			SchedulerFactory schedulerFactory = new StdSchedulerFactory();
		    Scheduler scheduler = schedulerFactory.getScheduler();
		    scheduler.start();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}

package com.cisco.kta.web.aclcommandoutput;

import java.util.List;

import com.cisco.kta.shct.database.handler.aclCommandOutputDBHandler;
import com.cisco.kta.shct.database.model.aclCommandOutputDto;
import com.opensymphony.xwork2.ActionSupport;

public class listtoday extends ActionSupport{
	private List<aclCommandOutputDto> aclCommandOutputDtoList;
	String device;

	public String execute() {
		try{
			aclCommandOutputDBHandler aclCommandOutputDBHandler = new aclCommandOutputDBHandler();
			aclCommandOutputDtoList = aclCommandOutputDBHandler.selectByDeviceToday(this.device);
		}catch(Exception e){
			e.printStackTrace();
		}
		return SUCCESS;
	}
	
	public List<aclCommandOutputDto> getAclCommandOutputDtoList() {
		return aclCommandOutputDtoList;
	}

	public void setDevice(String device) {
		this.device = device;
	}
	

}

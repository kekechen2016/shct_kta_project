package com.cisco.kta.web.aclcommandoutput;

import java.util.List;

import com.cisco.kta.shct.database.handler.aclCommandOutputDBHandler;
import com.cisco.kta.shct.database.model.aclCommandOutputDto;
import com.opensymphony.xwork2.ActionSupport;

public class listbydate extends ActionSupport{
	private List<aclCommandOutputDto> aclCommandOutputDtoList;
	String device;
	String date;
	public String execute() {
		try{
			aclCommandOutputDBHandler aclCommandOutputDBHandler = new aclCommandOutputDBHandler();
			aclCommandOutputDtoList = aclCommandOutputDBHandler.selectByDeviceByDate(this.device, this.date);
		}catch(Exception e){
			e.printStackTrace();
		}
		return SUCCESS;
	}
	public void setDevice(String device) {
		this.device = device;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public List<aclCommandOutputDto> getAclCommandOutputDtoList() {
		return aclCommandOutputDtoList;
	}
	
	

}

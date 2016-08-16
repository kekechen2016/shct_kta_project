package com.cisco.kta.web.asr9kcefusage;

import java.util.List;

import com.cisco.kta.shct.database.handler.asr9kCefUsageDBHandler;
import com.cisco.kta.shct.database.model.asr9kCefUsageDto;
import com.opensymphony.xwork2.ActionSupport;

public class linediagram extends ActionSupport{
	private List<asr9kCefUsageDto> asr9kCefUsageDtoList;
	private String device;
	private String slot;
	public String execute() {
		try {
			asr9kCefUsageDBHandler asr9kCefUsageDBHandler = new asr9kCefUsageDBHandler();
			asr9kCefUsageDtoList = asr9kCefUsageDBHandler.searchSlot(device, slot);
			for (asr9kCefUsageDto i : asr9kCefUsageDtoList){
				i.setPercent(i.getPercent().substring(0,2));
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return SUCCESS;
	}
	
	
	public void setDevice(String device) {
		this.device = device;
	}
	public void setSlot(String slot) {
		this.slot = slot;
	}
	public List<asr9kCefUsageDto> getAsr9kCefUsageDtoList() {
		return asr9kCefUsageDtoList;
	}
	

}

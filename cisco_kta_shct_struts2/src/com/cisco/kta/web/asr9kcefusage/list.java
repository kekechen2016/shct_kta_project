package com.cisco.kta.web.asr9kcefusage;

import java.io.IOException;
import java.util.List;

import com.cisco.kta.shct.database.handler.asr9kCefUsageDBHandler;
import com.cisco.kta.shct.database.model.asr9kCefUsageDto;
import com.opensymphony.xwork2.ActionSupport;

public class list extends ActionSupport{
	private List<asr9kCefUsageDto> asr9kCefUsageDtoList;
	public String execute() {
		try {
			asr9kCefUsageDBHandler asr9kCefUsageDBHandler = new asr9kCefUsageDBHandler();
			asr9kCefUsageDtoList = asr9kCefUsageDBHandler.searchAll();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return SUCCESS;
	}
	public List<asr9kCefUsageDto> getAsr9kCefUsageDtoList() {
		return asr9kCefUsageDtoList;
	}

}

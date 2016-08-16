package com.cisco.kta.shct.database.handler;

import java.io.IOException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.cisco.kta.shct.database.dao.asr9kCefUsageDtoMapper;
import com.cisco.kta.shct.database.model.asr9kCefUsageDto;




public class asr9kCefUsageDBHandler extends base{
	private List<asr9kCefUsageDto> asr9kCefUsageDtoList;
/*	public static void main(String args[]){
		try {
			asr9kCefUsageDBHandler aa = new asr9kCefUsageDBHandler();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
*/
	public asr9kCefUsageDBHandler() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public String insert(asr9kCefUsageDto asr9kCefUsageDto){
		SqlSession session = openSession();
		try{
			asr9kCefUsageDtoMapper asr9kCefUsageDM = session.getMapper(asr9kCefUsageDtoMapper.class);
			asr9kCefUsageDM.insertSelective(asr9kCefUsageDto);
		    session.commit();
		    }
		finally{
			session.close();
			}
		return "success";
	}
	
	public List<asr9kCefUsageDto> searchAll(){
		SqlSession session = openSession();
		try{
			asr9kCefUsageDtoMapper asr9kCefUsageDM = session.getMapper(asr9kCefUsageDtoMapper.class);
			this.asr9kCefUsageDtoList = asr9kCefUsageDM.selectAllByDesc();
		    session.commit();
		    }
		finally{
			session.close();
			}
		return this.asr9kCefUsageDtoList;
		}
	
	public List<asr9kCefUsageDto> searchSlot(String device, String slot){
		SqlSession session = openSession();
		try{
			asr9kCefUsageDtoMapper asr9kCefUsageDM = session.getMapper(asr9kCefUsageDtoMapper.class);
			this.asr9kCefUsageDtoList = asr9kCefUsageDM.selectBySlot(device, slot);
		    session.commit();
		    }
		finally{
			session.close();
			}
		return this.asr9kCefUsageDtoList;
		}
	public List<asr9kCefUsageDto> getAsr9kCefUsageDtoList() {
		return this.asr9kCefUsageDtoList;
	}
	

}

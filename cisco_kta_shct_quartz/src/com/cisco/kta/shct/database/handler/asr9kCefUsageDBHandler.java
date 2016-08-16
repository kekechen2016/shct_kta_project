package com.cisco.kta.shct.database.handler;

import java.io.IOException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;

import com.cisco.kta.shct.database.dao.asr9kCefUsageDtoMapper;
import com.cisco.kta.shct.database.model.asr9kCefUsageDto;




public class asr9kCefUsageDBHandler extends base{
	private static Logger logger = Logger.getLogger(asr9kCefUsageDBHandler.class);
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
		    }catch(Exception e){
		    	logger.info(e.getMessage(),e);
		    }
		finally{
			session.close();
			}
		return "success";
	}
	
	public void searchAll(){
		SqlSession session = openSession();
		try{
			asr9kCefUsageDtoMapper asr9kCefUsageDM = session.getMapper(asr9kCefUsageDtoMapper.class);
			this.asr9kCefUsageDtoList = asr9kCefUsageDM.selectAll();
		    session.commit();
		    }
		finally{
			session.close();
			}
		}
	public List<asr9kCefUsageDto> getAsr9kCefUsageDtoList() {
		return asr9kCefUsageDtoList;
	}
	

}

package com.cisco.kta.shct.database.handler;

import java.io.IOException;

import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;

import com.cisco.kta.shct.database.dao.aclCommandOutputDtoMapper;
import com.cisco.kta.shct.database.model.aclCommandOutputDto;

public class aclCommandOutputDBHandler extends base{
	private static Logger logger = Logger.getLogger(aclCommandOutputDBHandler.class);
	
	public aclCommandOutputDBHandler() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public String insert(aclCommandOutputDto aclCommandOutputDto){
		SqlSession session = openSession();
		try{
			aclCommandOutputDtoMapper aclCommandOutputDM = session.getMapper(aclCommandOutputDtoMapper.class);
			aclCommandOutputDM.insertSelective(aclCommandOutputDto);
		    session.commit();
		    }catch(Exception e){
		    	logger.info(e.getMessage(),e);
		    }
		finally{
			session.close();
			}
		return "success";
	}
	

}

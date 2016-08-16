package com.cisco.kta.shct.database.handler;

import java.io.IOException;

import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;

import com.cisco.kta.shct.database.dao.asr9kUnicastFloodingDtoMapper;
import com.cisco.kta.shct.database.model.asr9kUnicastFloodingDto;

public class asr9kUnicastFloodingDBHandler extends base{
	private static Logger logger = Logger.getLogger(asr9kUnicastFloodingDBHandler.class);
	public asr9kUnicastFloodingDBHandler() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}

	public String insert(asr9kUnicastFloodingDto asr9kUnicastFloodingDto){
		SqlSession session = openSession();
		try{
			asr9kUnicastFloodingDtoMapper aclCommandOutputDM = session.getMapper(asr9kUnicastFloodingDtoMapper.class);
			aclCommandOutputDM.insertSelective(asr9kUnicastFloodingDto);
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

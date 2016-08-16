package com.cisco.kta.shct.database.handler;

import java.io.IOException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;

import com.cisco.kta.shct.database.dao.aclCommandOutputDtoMapper;
import com.cisco.kta.shct.database.model.aclCommandOutputDto;

public class aclCommandOutputDBHandler extends base{
	private static Logger logger = Logger.getLogger(aclCommandOutputDBHandler.class);
	private List<aclCommandOutputDto> aclCommandOutputDtoList;
	
	
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
	
	public List<aclCommandOutputDto> selectByDeviceToday(String device){
		SqlSession session = openSession();
		try{
			aclCommandOutputDtoMapper aclCommandOutputDM = session.getMapper(aclCommandOutputDtoMapper.class);
			this.aclCommandOutputDtoList = aclCommandOutputDM.selectByDeviceToday(device);
		    session.commit();
		    }catch(Exception e){
		    	logger.info(e.getMessage(),e);
		    }
		finally{
			session.close();
			}
		return this.aclCommandOutputDtoList;
	}
	
	public List<aclCommandOutputDto> selectByDeviceAll(String device){
		SqlSession session = openSession();
		try{
			aclCommandOutputDtoMapper aclCommandOutputDM = session.getMapper(aclCommandOutputDtoMapper.class);
			this.aclCommandOutputDtoList = aclCommandOutputDM.selectByDeviceAll(device);
		    session.commit();
		    }catch(Exception e){
		    	logger.info(e.getMessage(),e);
		    }
		finally{
			session.close();
			}
		return this.aclCommandOutputDtoList;
	}
	public List<aclCommandOutputDto> selectByDeviceByDate(String device, String date){
		SqlSession session = openSession();
		try{
			aclCommandOutputDtoMapper aclCommandOutputDM = session.getMapper(aclCommandOutputDtoMapper.class);
			this.aclCommandOutputDtoList = aclCommandOutputDM.selectByDeviceByDate(device, date);
		    session.commit();
		    }catch(Exception e){
		    	logger.info(e.getMessage(),e);
		    }
		finally{
			session.close();
			}
		return this.aclCommandOutputDtoList;
	}

}

package com.cisco.kta.shct.database.handler;

import java.io.IOException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;

import com.cisco.kta.shct.database.dao.asr9kUnicastFloodingDtoMapper;
import com.cisco.kta.shct.database.model.asr9kUnicastFloodingDto;

public class asr9kUnicastFloodingDBHandler extends base{
	private static Logger logger = Logger.getLogger(asr9kUnicastFloodingDBHandler.class);
	private List<asr9kUnicastFloodingDto> asr9kUnicastFloodingDtoList;
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
	public List<asr9kUnicastFloodingDto> selectAllToday(){
		SqlSession session = openSession();
		try{
			asr9kUnicastFloodingDtoMapper asr9kUnicastFloodingDM = session.getMapper(asr9kUnicastFloodingDtoMapper.class);
			this.asr9kUnicastFloodingDtoList = asr9kUnicastFloodingDM.selectAllToday();
		    session.commit();
		    }catch(Exception e){
		    	logger.info(e.getMessage(),e);
		    }
		finally{
			session.close();
			}
		return this.asr9kUnicastFloodingDtoList;
	}
	public List<asr9kUnicastFloodingDto> selectByDeviceByDate(String device, String date){
		SqlSession session = openSession();
		try{
			asr9kUnicastFloodingDtoMapper asr9kUnicastFloodingDM = session.getMapper(asr9kUnicastFloodingDtoMapper.class);
			this.asr9kUnicastFloodingDtoList = asr9kUnicastFloodingDM.selectByDeviceByDate(device, date);
		    session.commit();
		    }catch(Exception e){
		    	logger.info(e.getMessage(),e);
		    }
		finally{
			session.close();
			}
		return this.asr9kUnicastFloodingDtoList;
	}
	public List<asr9kUnicastFloodingDto> selectByDeviceByPort(String device, String port){
		SqlSession session = openSession();
		try{
			asr9kUnicastFloodingDtoMapper asr9kUnicastFloodingDM = session.getMapper(asr9kUnicastFloodingDtoMapper.class);
			this.asr9kUnicastFloodingDtoList = asr9kUnicastFloodingDM.selectByDeviceByPort(device, port);
		    session.commit();
		    }catch(Exception e){
		    	logger.info(e.getMessage(),e);
		    }
		finally{
			session.close();
			}
		return this.asr9kUnicastFloodingDtoList;
	}
	public List<asr9kUnicastFloodingDto> selectAllByDate(String date){
		SqlSession session = openSession();
		try{
			asr9kUnicastFloodingDtoMapper asr9kUnicastFloodingDM = session.getMapper(asr9kUnicastFloodingDtoMapper.class);
			this.asr9kUnicastFloodingDtoList = asr9kUnicastFloodingDM.selectAllByDate(date);
		    session.commit();
		    }catch(Exception e){
		    	logger.info(e.getMessage(),e);
		    }
		finally{
			session.close();
			}
		return this.asr9kUnicastFloodingDtoList;
	}

}

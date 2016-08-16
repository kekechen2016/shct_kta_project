package com.cisco.kta.shct.database.handler;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class base {
	
	private static SqlSessionFactory factory = null;
	public base() throws IOException{
		if (factory != null) return;
	    InputStream is = this.getClass().getClassLoader().getResourceAsStream("MapperConfig.xml");
	    factory = new SqlSessionFactoryBuilder().build(is);

	  }
	  
	  /**
	   * 获取SqlSession实例，使用后需调用实例的close()函数释放资源
	   * @return
	   */
	  protected SqlSession openSession(){
	    return factory.openSession();
	  }

}

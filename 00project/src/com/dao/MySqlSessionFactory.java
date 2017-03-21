package com.dao;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;



//mybatis sqlsession return
public class MySqlSessionFactory {
   private static SqlSessionFactory sqlSessionFactory;
   static{
   String resource = "com/config/Configuration.xml";
   InputStream inputStream = null;
   try {
      inputStream = Resources.getResourceAsStream(resource);
   } catch (IOException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
   }
   sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
   
   }
   public static SqlSession openSesstion(){
      return sqlSessionFactory.openSession();
   }
   
}
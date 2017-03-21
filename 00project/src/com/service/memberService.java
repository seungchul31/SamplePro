package com.service;

import java.util.HashMap;

import org.apache.ibatis.session.SqlSession;

import com.Exception.CommonException;
import com.dao.MySqlSessionFactory;
import com.entity.MemberDTO;

public class memberService {
 private String namespace = "com.acorn.MemberMapper.";
 
      
    public MemberDTO login(HashMap<String, String>map)throws CommonException{
    	MemberDTO dto = null;
    	SqlSession session = MySqlSessionFactory.openSesstion();
    	System.out.println("DTO:"+dto);
    	try{
    		dto = session.selectOne(namespace+"login",map);
    	}catch(Exception e){
    		e.printStackTrace();
    		throw new CommonException("로그인 실패");
    	}finally{
    		session.close();
    	}
    	return dto;
    }
 
 
	
	public void addMember(MemberDTO dto)throws CommonException{
		SqlSession session = MySqlSessionFactory.openSesstion();
		try{
			int n = session.insert(namespace+"addMember",dto);
			session.commit();
		}catch(Exception e){
			e.printStackTrace();
			throw new CommonException("회원가입실패");
		}finally{
			session.close();
		}
	}
}

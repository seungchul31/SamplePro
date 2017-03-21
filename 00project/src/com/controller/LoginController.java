package com.controller;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.Exception.CommonException;
import com.entity.MemberDTO;
import com.service.memberService;

@WebServlet("/LoginController")
public class LoginController extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String userid = request.getParameter("userid");
		String passwd = request.getParameter("passwd");
		
		HashMap<String, String> map = new HashMap<>();
		map.put("userid", userid);
		map.put("passwd", passwd);
		System.out.println(userid+" / "+passwd);
		memberService service = new memberService();
		String target="";
		try{
		MemberDTO dto = service.login(map);
		System.out.println(dto);
		 if(dto == null){
			 target="LoginFormController";
		 }else{
			 target="home";
			 HttpSession session = request.getSession();
			 session.setAttribute("login", dto);
		 }
		}catch(CommonException e){
			target="error.jsp";
			request.setAttribute("message",e.getMessage());
			request.setAttribute("link", "LoginFormController");
		}
		
		
		RequestDispatcher dis = request.getRequestDispatcher(target);
		dis.forward(request, response);
		}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}

package com.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Exception.CommonException;
import com.entity.MemberDTO;
import com.service.memberService;

@WebServlet("/MemberAddController")
public class MemberAddController extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		request.setCharacterEncoding("UTF-8");
		String userid = request.getParameter("userid");
		String passwd = request.getParameter("passwd");
		String nickname = request.getParameter("nickname");
		String year = request.getParameter("year");
		String month = request.getParameter("month");
		String day = request.getParameter("day");
		String gender = request.getParameter("gender");
		
		MemberDTO dto = new MemberDTO(userid,passwd,nickname,year,month,day,gender);
		memberService service = new memberService();
		String target="";
		try{
			service.addMember(dto);
			target = "home";
			request.setAttribute("success", "회원 가입 성공");
		}catch(CommonException e){
			target="error.jsp";
			request.setAttribute("message",e.getMessage());
			request.setAttribute("link", "MemberFormController");
		}
		RequestDispatcher dis = request.getRequestDispatcher(target);
		dis.forward(request, response);
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}

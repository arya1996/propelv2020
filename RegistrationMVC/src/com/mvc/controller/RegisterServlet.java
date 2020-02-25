package com.mvc.controller;

import java.io.IOException;
import java.text.ParseException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mvc.bean.RegisterBean;
import com.mvc.dao.RegisterDaoServices;

//@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public RegisterServlet() {

	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		String fullName = request.getParameter("fullName");
		String email = request.getParameter("email");
		String userName = request.getParameter("userName");
		String password = request.getParameter("password");
		String gender = request.getParameter("gender");
		String active = request.getParameter("check1");
		String date = request.getParameter("date");
		String roleName = request.getParameter("role");
		java.util.Date regDate = null;

		java.text.DateFormat format = new java.text.SimpleDateFormat(
				"yyyy-MM-dd");

		try {
			regDate = format.parse(date);
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		RegisterBean registerBean = new RegisterBean();

		registerBean.setFullName(fullName);
		registerBean.setEmail(email);
		registerBean.setUserName(userName);
		registerBean.setPassword(password);
		registerBean.setGender(gender);
		registerBean.setDate(regDate);
		registerBean.setActive(active);
		registerBean.setRoleId(roleName);

		RegisterDaoServices registerDao = new RegisterDaoServices();

		try {
			String registerUser = registerDao.registerUser(registerBean);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		request.getRequestDispatcher("/JSP/Home.jsp")
				.forward(request, response);
	}

}

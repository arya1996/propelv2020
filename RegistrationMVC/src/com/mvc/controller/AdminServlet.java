package com.mvc.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mvc.bean.RegisterBean;
import com.mvc.dao.RegisterDaoServices;


@WebServlet("/")
public class AdminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private RegisterDaoServices registerDao;

	public void init() {
		registerDao = registerDao.getInstance();
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		String action = request.getServletPath();
		try {
			switch (action) {
			case "/new":
				showNewForm(request, response);
				break;
			case "/insert":
				try {
					insertUser(request, response);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
			case "/delete":
				deleteUser(request, response);
				break;
			case "/edit":
				showEditForm(request, response);
				break;
			case "/update":
				updateUser(request, response);
				break;
			default:
				listUser(request, response);
				break;
			}
		} catch (SQLException ex) {
			throw new ServletException(ex);
		}

	}

	// List all users
	public void listUser(HttpServletRequest request,
			HttpServletResponse response) throws SQLException, IOException,
			ServletException {

		List<RegisterBean> listUser = registerDao.selectAllUsers();
		request.setAttribute("listUser", listUser);
		RequestDispatcher dispatcher = request
				.getRequestDispatcher("JSP/Register-list.jsp");
		dispatcher.forward(request, response);
	}

	// Add user
	public void showNewForm(HttpServletRequest request,
			HttpServletResponse response) throws SQLException, IOException,
			ServletException {

		RequestDispatcher dispatcher = request
				.getRequestDispatcher("JSP/Admin.jsp");
		dispatcher.forward(request, response);

	}

	// Edit and Update
	private void showEditForm(HttpServletRequest request,
			HttpServletResponse response) throws SQLException,
			ServletException, IOException {

		int id = Integer.parseInt(request.getParameter("id"));
		System.out.println(request.getParameter("id"));
		RegisterBean existingUser = registerDao.selectUser(id);
		RequestDispatcher dispatcher = request
				.getRequestDispatcher("JSP/Admin.jsp");
		request.setAttribute("user", existingUser);
		dispatcher.forward(request, response);

	}

	private void insertUser(HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		String fullName = request.getParameter("fullName");
		String email = request.getParameter("email");
		String userName = request.getParameter("userName");
		String password = request.getParameter("password");
		String active = request.getParameter("status");
		String role = request.getParameter("role");
		String gender = request.getParameter("gender");
		String date = request.getParameter("date");
		java.util.Date regDate = null;

		java.text.DateFormat format = new java.text.SimpleDateFormat(
				"yyyy-MM-dd");

		try {
			regDate = format.parse(date);
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		RegisterBean newUser = new RegisterBean(fullName, email, userName,
				password,active,role,gender,regDate);
		
		String result = registerDao.registerUser(newUser);
		
		if (result.equals("SUCCESS")) {
			response.sendRedirect("list");
		} else {
			System.out.println("Not inserted");
		}
	}
	
	private void updateUser(HttpServletRequest request,HttpServletResponse response)throws SQLException,IOException{
		
		int slNo = Integer.parseInt(request.getParameter("id"));
		String fullName = request.getParameter("fullName");
		String email = request.getParameter("email");
		String userName = request.getParameter("userName");
		String password = request.getParameter("password");
		String active = request.getParameter("status");
			
		String role = request.getParameter("role");
		String gender = request.getParameter("gender");
		String date = request.getParameter("date");
		java.util.Date regDate = null;

		java.text.DateFormat format = new java.text.SimpleDateFormat(
				"yyyy-MM-dd");

		try {
			regDate = format.parse(date);
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		RegisterBean registerData = new RegisterBean(slNo, fullName, email, userName, password, active, role, gender, regDate);
		
		registerDao.updateUser(registerData);
		response.sendRedirect("list");
	}
   
	 private void deleteUser(HttpServletRequest request,HttpServletResponse response)throws SQLException,IOException{
			
		 int id=Integer.parseInt(request.getParameter("id"));
		 registerDao.deleteUser(id);
		response.sendRedirect("list");
	 }
}

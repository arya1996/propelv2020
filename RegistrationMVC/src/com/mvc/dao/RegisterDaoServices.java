
package com.mvc.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.mvc.bean.RegisterBean;
import com.mvc.helper.ConnectionFactory;

public class RegisterDaoServices {

	// Implements singleton design pattern
	private static RegisterDaoServices instance = null;

	//Default constructor
	public RegisterDaoServices() {
		super();
		// TODO Auto-generated constructor stub
	}

	// getInstance method
	public static RegisterDaoServices getInstance() {
		if (instance == null) {
			instance = new RegisterDaoServices();
		}
		return instance;
	}

	//SQL queries
	private static final String INSERT_USERS_SQL = "insert into users(usr_fullName,usr_email,usr_userName,usr_password,usr_isActive,usr_role,usr_gender,usr_date)values(?,?,?,?,?,?,?,?)";
	private static final String SELECT_USER_BY_ID = "SELECT * from users where usr_slNo =?";
	private static final String SELECT_ALL_USERS = "SELECT * from users";
	private static final String DELETE_USERS_SQL = "DELETE from users where usr_slNo=?";
	private static final String UPDATE_USERS_SQL = "UPDATE users  set usr_fullName=?,usr_email=?,usr_userName=?,usr_password=?,usr_isActive=?,usr_role=?,usr_gender=?,usr_date=? where usr_slNo=?";

	// creating objects
	private Connection connection = null;
	private PreparedStatement statement = null;
	private ResultSet resultSet = null;

	public String registerUser(RegisterBean registerBean) throws Exception {

		try {
			//creating connection
			connection = ConnectionFactory.getConnection();
			statement = connection.prepareStatement(INSERT_USERS_SQL);
			statement.setString(1, registerBean.getFullName());
			statement.setString(2, registerBean.getEmail());
			statement.setString(3, registerBean.getUserName());
			statement.setString(4, registerBean.getPassword());
			statement.setString(5, registerBean.getActive());
			statement.setString(6, registerBean.getRoleId());
			statement.setString(7, registerBean.getGender());					
			statement.setDate(8, new java.sql.Date(registerBean.getDate()
					.getTime()));
			int i = statement.executeUpdate();

			if (i != 0)
				return "SUCCESS";

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return "Oops..Something went wrong there..!";

	}

	public RegisterBean selectUser(int id) {
		RegisterBean register = null;
		try {
			//creating connection
			connection = ConnectionFactory.getConnection();
			statement = connection.prepareStatement(SELECT_USER_BY_ID);
			statement.setInt(1, id);
			System.out.println(statement);
			resultSet = statement.executeQuery();
			while (resultSet.next()) {
				Integer slNo = resultSet.getInt("usr_slNo");
				String fullname = resultSet.getString("usr_fullName");
				String email = resultSet.getString("usr_email");
				String userName = resultSet.getString("usr_userName");
				String password = resultSet.getString("usr_passWord");
				String active = resultSet.getString("usr_isActive");
				String role = resultSet.getString("usr_role");
				String gender = resultSet.getString("usr_gender");
				Date date = resultSet.getDate("usr_date");
				register = new RegisterBean(slNo, fullname, email, userName,
						password, active,role,gender,date);
			}
		} catch (SQLException e) {
			// TODO: handle exception
			System.out.println(e);
		} catch (IOException e) {
			// TODO: handle exception
			e.printStackTrace();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();

		}
		return register;

	}
	
	public List<RegisterBean> selectAllUsers() {

		//creating arraylist
		List<RegisterBean> users = new ArrayList<RegisterBean>();
		try {
			connection = ConnectionFactory.getConnection();
			statement = connection.prepareStatement(SELECT_ALL_USERS);
			System.out.println(statement);
			resultSet = statement.executeQuery();
			while (resultSet.next()) {
				Integer slNo = resultSet.getInt("usr_slNo");
				String fullname = resultSet.getString("usr_fullName");
				String email = resultSet.getString("usr_email");
				String userName = resultSet.getString("usr_userName");
				String password = resultSet.getString("usr_passWord");
				String active = resultSet.getString("usr_isActive");
				String role = resultSet.getString("usr_role");
				String gender = resultSet.getString("usr_gender");
				Date date = resultSet.getDate("usr_date");
				 users.add(new RegisterBean(slNo, fullname, email, userName,
						password, active,role,gender,date));

			}
		} catch (SQLException e) {
			System.out.println(e);
		} catch (IOException e) {
			// TODO: handle exception
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return users;
	}

	public boolean deleteUser(int id) throws SQLException{
		
		boolean rowDeleted=false;
		try{
			connection = ConnectionFactory.getConnection();
			statement = connection.prepareStatement(DELETE_USERS_SQL);
			statement.setInt(1, id);
			rowDeleted = statement.executeUpdate() > 0;

		}
		catch (SQLException e) {
			System.out.println(e);
		} catch (IOException e) {
			// TODO: handle exception
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return rowDeleted;
	}
	
public boolean updateUser(RegisterBean register) throws SQLException{
		
		boolean rowUpdated=false;
		
		try
		{
			//creating connection
			connection=ConnectionFactory.getConnection();
			statement=connection.prepareStatement(UPDATE_USERS_SQL);
			statement.setString(1, register.getFullName());
			statement.setString(2, register.getEmail());
			statement.setString(3, register.getUserName());
			statement.setString(4, register.getPassword());
			statement.setString(5, register.getActive());
			statement.setString(6, register.getRoleId());
			statement.setString(7, register.getGender());
			statement.setDate(8, new java.sql.Date(register.getDate()
					.getTime()));
			statement.setInt(9,register.getid());

			rowUpdated = statement.executeUpdate() > 0;
		}catch(SQLException e){
			System.out.println(e);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rowUpdated;
	}


}

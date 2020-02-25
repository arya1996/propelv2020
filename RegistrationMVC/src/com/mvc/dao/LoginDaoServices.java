package com.mvc.dao;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.ResultSet;
import com.mvc.bean.LoginBean;
import com.mvc.helper.ConnectionFactory;

public class LoginDaoServices {

	public String authenticateUser(LoginBean loginBean) {

		String userName = loginBean.getUserName();
		String password = loginBean.getPassword();

		Connection con = null;
		Statement statement = null;
		ResultSet resultSet = null;

		String userNameDB = "";
		String passwordDB = "";
		String roleDB = "";

		try {

			con = ConnectionFactory.getConnection();
			statement = con.createStatement();
			resultSet = statement
					.executeQuery("select usr_userName,usr_passWord,usr_role from users");

			while (resultSet.next()) {

				userNameDB = resultSet.getString("usr_userName");
				passwordDB = resultSet.getString("usr_passWord");
				roleDB = resultSet.getString("usr_role");

				if (userName.equals(userNameDB) && password.equals(passwordDB)
						&& roleDB.equals("Admin")) {

					return "Admin_Role";
				} else if (userName.equals(userNameDB)
						&& password.equals(passwordDB)
						&& roleDB.equals("Editor"))
					return "Editor_Role";
				else if (userName.equals(userNameDB)
						&& password.equals(passwordDB) && roleDB.equals("User"))
					return "User_Role";
			}

		} catch (Exception e) {
			// TODO: handle exception
		}
		return "Invalid user credenatials";

	}

}

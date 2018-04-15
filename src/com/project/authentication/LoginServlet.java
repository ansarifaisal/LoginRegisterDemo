package com.project.authentication;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.project.dbutil.DBUtil;
import com.project.repository.SQLRepository;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/loginServ")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */

	Connection connection = DBUtil.getConnection();

	public LoginServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setAttribute("greeting", "Hello World");
		request.getRequestDispatcher("login.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		SQLRepository sqlRepository = new SQLRepository(connection);
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		ResultSet resultSet = sqlRepository.doLogin(username, password);
		if (resultSet == null)
			return;

		boolean isFirstLogin = false;
		String tempUsername = null;
		String tempPassword = null;
		String msg = null;
		try {
			while (resultSet.next()) {
				isFirstLogin = resultSet.getBoolean("IS_FIRST_LOGIN");
				tempUsername = resultSet.getString("USER_NAME");
				tempPassword = resultSet.getString("PASSWORD");
			}
		} catch (SQLException e) {
			System.out.print("ResultSet Error -> ");
			System.out.println(e.getMessage());
		}

		if (tempUsername == null || tempPassword == null) {
			msg = "Invalid username and password";
			request.setAttribute("msg", msg);
			doGet(request, response);
			return;
		}

		if (!(tempUsername.equals(username) && tempPassword.equals(password))) {
			msg = "Invalid username and password";
			request.setAttribute("msg", msg);
			doGet(request, response);
			return;
		}

		if (resultSet != null && !isFirstLogin)
			response.sendRedirect("/LoginRegister/resetServ?username=" + username);
		else if (resultSet != null && isFirstLogin)
			request.getRequestDispatcher("/homeServ").forward(request, response);
		else
			doGet(request, response);
	}

}

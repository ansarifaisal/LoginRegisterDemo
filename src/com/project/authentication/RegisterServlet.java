package com.project.authentication;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.project.dbutil.DBUtil;
import com.project.repository.SQLRepository;

/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/registerServ")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	Connection connection = DBUtil.getConnection();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public RegisterServlet() {
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
		request.getRequestDispatcher("register.jsp").forward(request, response);
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
		boolean flag = sqlRepository.insertRegister(username, password);
		if (flag)
			response.sendRedirect("/LoginRegister/loginServ");
		else
			doGet(request, response);
	}

}

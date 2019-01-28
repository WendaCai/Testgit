package com.spark.ex.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

import com.spark.ex.hibernatepojo.ERS_User_Roles;
import com.spark.ex.hibernatepojo.ERS_Users;
import com.spark.ex.launcher.Launcher;
public class ReimbursementServlet extends HttpServlet {
	private Launcher launcher;
	ERS_User_Roles User_Roles;
	@Override
    public void init() throws ServletException {
        launcher = new Launcher();
        try {
            Class.forName("com.fasterxml.jackson.databind.ObjectMapper");
        } catch (ClassNotFoundException e) {
            throw new ServletException("Can't load jackson");
        }
    }
protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	User_Roles = new ObjectMapper().readValue(request.getInputStream(), ERS_User_Roles.class);
	}
protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	ERS_Users user = new ObjectMapper().readValue(request.getInputStream(), ERS_Users.class);
	String Manager = "manager";
	String Employee = "employee";
	if(User_Roles.getUser_role().equals(Manager)){
		 response.getWriter().write(new ObjectMapper().writeValueAsString(launcher.getAllReimbursement()));
	}
//	else if (User_Roles.getUser_role().equals(Employee)) {
//		 response.getWriter().write(new ObjectMapper().writeValueAsString(launcher.getUserbyUsername(user)));
//	}
}
}

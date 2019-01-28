package com.spark.ex.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

import com.spark.ex.hibernatepojo.ERS_Users;
import com.spark.ex.launcher.Launcher;

public class LoginServlet extends HttpServlet {
	private Launcher launcher;
       
	@Override
    public void init() throws ServletException {
        launcher = new Launcher();
        try {
            Class.forName("com.fasterxml.jackson.databind.ObjectMapper");
        } catch (ClassNotFoundException e) {
            throw new ServletException("Can't load jackson");
        }
    }
	  @Override
	    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	        // will respond to an auth request.
	        // the body must contain a user object
	        // returns 200 for auth and 401 for unauth
	        // 400 for unacceptable requests

	        // get post data from request
	        ERS_Users user = new ObjectMapper().readValue(req.getInputStream(), ERS_Users.class);

	        System.out.println(user);

	        if(user == null) {
	            // not data or unparseable data
				System.out.println("inside the first if");
	            resp.setStatus(400);
	            resp.getWriter().write("No data submitted");
	            return;
	        } else {
	            // authenticate user with database
				System.out.println("INside the first else");
	            user = launcher.authUser(user);

	            if(user != null) {
	                // everything is good send auth data
					System.out.println("inside the second if");
	                resp.setStatus(200);
	                resp.getWriter().write(new ObjectMapper().writeValueAsString(user));
	                return;
	            }
	        }


	        // unauthorized
	        resp.setStatus(401);
	        resp.getWriter().write("Email or password was incorrect");
	    }
	

   
	
}



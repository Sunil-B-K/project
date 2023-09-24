package com.shopNest.customer;

import java.io.IOException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
@WebServlet("/log")
public class LoginServlet extends HttpServlet{
	public void doPost(HttpServletRequest req,HttpServletResponse resp) throws IOException {
		String uname=req.getParameter("uname");
		String pas=req.getParameter("password");
		boolean val=Validator.isValid(uname,pas);
		if(val==true &&uname.equals("admin")) {
			resp.sendRedirect("admin.jsp");		
		}
		else if(val==true) {
			resp.sendRedirect("home.jsp");
		}
		else {
			resp.sendRedirect("Login.jsp");
		}
	}

}

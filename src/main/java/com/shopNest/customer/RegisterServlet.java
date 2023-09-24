package com.shopNest.customer;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import com.shopNest.dbHandler.DataInjector;
@WebServlet("/regi")
public class RegisterServlet extends HttpServlet{
	public void doPost(HttpServletRequest req,HttpServletResponse resp) throws IOException {
	 	String nam=req.getParameter("name");
	 	String pass=req.getParameter("password");
	 	String ema=req.getParameter("email");
	 	String add=req.getParameter("address");
	 	String gen=req.getParameter("gender");
	 	DataInjector.addCustomer(nam, ema, pass, add, gen);
	 	resp.sendRedirect("login.jsp");
	}

}

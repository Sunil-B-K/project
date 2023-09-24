package com.shopNest.admin;

import java.io.IOException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import com.shopNest.dbHandler.DataInjector;

@WebServlet("/addP")
public class Admin extends HttpServlet  {
	
		public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException  {
			int pid=Integer.parseInt(req.getParameter("product-id"));
			String pname=req.getParameter("product-name");
			String pdesc=req.getParameter("product-description");
			int pprice=Integer.parseInt(req.getParameter("product-price"));
			String pimg=req.getParameter("product-image");
			
			DataInjector.addProduct(pid, pname, pdesc, pprice, pimg);
		}

	}


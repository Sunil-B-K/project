package com.shopNest.dbHandler;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class DataInjector {
	public static String  addCustomer(String nam,String email ,String password,String add,String gen)  {
		String driver="oracle.jdbc.driver.OracleDriver";
		String url="jdbc:oracle:thin:@localhost:1521:xe";
		String user="system";
		String pass="system";
		String sql="insert into customer values(?,?,?,?,?)";
		String regStatus="";
		try {
			Class.forName(driver);
			Connection con=DriverManager.getConnection(url, user, pass);
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setString(1, nam);
			ps.setString(2, email);
			ps.setString(3, password);
			ps.setString(4, add);
			ps.setString(5, gen);
			ps.executeUpdate();
			regStatus="success";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("problem in addding coutomer");
			e.printStackTrace();
			regStatus="failed";
		}
		finally {
			return regStatus;
		}
	}
	public static boolean addProduct(int pid,String pname,String pdesc,int pprice,String pimg){
		
		String url="jdbc:oracle:thin:@localhost:1521:xe";
		String user="system";
		String password="system";
		String sql="INSERT INTO products VALUES(?,?,?,?,?)";
		try{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con=DriverManager.getConnection(url, user, password);
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setInt(1, pid);
			ps.setString(2, pname);
			ps.setString(3, pdesc);
			ps.setInt(4, pprice);
			ps.setString(5, pimg);
			ps.executeUpdate();
		}catch(Exception e){
			System.out.println("Problem in adding product");
			e.printStackTrace();
			return false;
		}			
		return true;
	}
		
	}


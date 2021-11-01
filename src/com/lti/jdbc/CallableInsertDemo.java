package com.lti.jdbc;

import java.sql.*;
import java.util.Scanner;

public class CallableInsertDemo {

	public static void main(String[] args) {
		Connection con = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "LTI2","User12345");
			Scanner s = new Scanner(System.in);
			System.out.println("enter dept no");
			int deptno = s.nextInt();
			
			System.out.println("enter dept name");
			String dname = s.next();
			
			String s1 = "{call insdept(?, ?)}";
			CallableStatement cst = con.prepareCall(s1);
			cst.setInt(1, deptno);
			cst.setString(2, dname);
			cst.execute();
			System.out.println("INserted");
			
		}
		catch(ClassNotFoundException ce){
			ce.printStackTrace();
		}
		catch(SQLException se){
			se.printStackTrace();
		}
		finally {
			try {
				con.close();
			}
			catch(Exception e){
				e.printStackTrace();
			}
		}

	}

}



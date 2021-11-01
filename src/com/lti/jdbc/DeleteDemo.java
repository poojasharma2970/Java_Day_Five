package com.lti.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class DeleteDemo {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Scanner s = new Scanner(System.in);
		System.out.println("Enter the Dept no to Delete");
		int deptno = s.nextInt();

		
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","LTI2","User12345");
		String str = "delete from dept1 where deptno=?";
		PreparedStatement pst = con.prepareStatement(str);
		pst.setInt(1, deptno);
		int i = pst.executeUpdate();
		if(i!=0){
			System.out.println("Deleted Succesfully!!");
			String str1 = "Select * from dept1";
			Statement st1 = con.createStatement();
			ResultSet rs = st1.executeQuery(str1);
			System.out.println("Deptno\tDeptname\n");

			while(rs.next()) {
				System.out.print(rs.getInt(1)+"\t");
				System.out.print(rs.getString(2)+"\n");
			}
	
		}

	}

}

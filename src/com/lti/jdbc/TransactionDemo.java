package com.lti.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class TransactionDemo {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {

		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "LTI2", "User12345");
		con.setAutoCommit(false);
		Scanner s=new Scanner(System.in);
		System.out.println("Enter dno to be deleted: ");
		int deptno=s.nextInt();
		String str="delete from dept1 where deptno=?";
		PreparedStatement pst=con.prepareStatement(str);
		pst.setInt(1, deptno);
		pst.executeUpdate();
	
		System.out.println("Are you sure you want to delete(y/n)");
		String choice=s.next();
		if(choice.equalsIgnoreCase("y")) {
			con.commit();
			System.out.println("updated successfully!");
		}
		else
		{
			con.rollback();
			System.out.println("Data restored");
		}
	}

}

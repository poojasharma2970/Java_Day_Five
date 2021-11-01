package com.lti.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

public class ResultSetMetaDataDemo {

	public static void main(String[] args) throws SQLException, ClassNotFoundException {
		
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","LTI2","User12345");
		String str = "select * from dept1";
		
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery(str);
		System.out.println("Deptno\tDeptname\n");
		
		while(rs.next()) {
			System.out.print(rs.getInt(1)+"\t");
			System.out.print(rs.getString(2));
			System.out.println();
		}
		
		ResultSetMetaData rsmd = rs.getMetaData();
		int i = rsmd.getColumnCount();
		System.out.println(i);
		System.out.println("Display Size "+rsmd.getColumnDisplaySize(2));
		System.out.println("Column Name "+rsmd.getColumnClassName(2));
		
		for(int j = 1; j<rsmd.getColumnCount();j++) {
			System.out.println("Datatype: "+rsmd.getColumnType(j));
			System.out.println("Column Name: "+rsmd.getColumnName(j));
		}

	}

}

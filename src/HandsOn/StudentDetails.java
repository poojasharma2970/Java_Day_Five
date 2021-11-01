package HandsOn;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class StudentDetails {

	public static void main(String[] args) throws SQLException, ClassNotFoundException {
		Class.forName("oracle.jdbc.driver.OracleDriver");
	    Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "LTI2", "User12345");
	    
	    Scanner sc= new Scanner(System.in);
	    int ch;
	    
	    do {
	        System.out.println("------------------------------------------------------------------");    
	        System.out.println("Enter You Choice of DML statement to Run on book_details table:\n");
	        System.out.println("1. Select");
	        System.out.println("2. Insert");
	        System.out.println("3. Update");
	        System.out.println("4. Delete");
	        ch=sc.nextInt();
	        int student_id;
	        String student_name;
	        String discipline;
	        int book_id;
	        
	        switch(ch) {
	        case 1:
	            String str1="select * from students_details";
	            Statement st1=con.createStatement();
	            ResultSet rs= st1.executeQuery(str1);
	            System.out.println("student_id\tstudent_name\tdiscipline\tbook_id");
	            while(rs.next()) {
	                System.out.print(rs.getInt(1)+"\t\t");
	                System.out.print(rs.getString(2)+"\t\t");
	                System.out.print(rs.getString(3)+"\t");
	                System.out.print("\t"+rs.getInt(4)+"\t");
	                System.out.println();
	            }
	            break;
	          
	        case 2 :
	            System.out.println("Enter student ID : ");
	            student_id=sc.nextInt();
	            System.out.println("Enter the Student Name : "); 
	            sc.nextLine();
	            student_name=sc.nextLine();
	            System.out.println("Enter the Discipline : ");
	            discipline=sc.nextLine();
	            System.out.println("Enter the Book ID : ");
	            book_id=sc.nextInt();
	            String str2="insert into students_details values('"+student_id+"','"+student_name+"','"+discipline+"','"+book_id+"')";
	            Statement st=con.createStatement();
	            int i=st.executeUpdate(str2);
	            if(i!=0) 
	                System.out.println("\nInserted successfully!!!\n");
	            break;
	         
	        case 3 :
	            System.out.println("Enter the Student ID : ");
	            student_id=sc.nextInt();
	            System.out.println("Enter the Student Name : ");
	            student_name=sc.next();
	            String str3 = "update book_details set student_name=? where student_id=?";
	            PreparedStatement pst = con.prepareStatement(str3);
	            pst.setString(1, student_name);
	            pst.setInt(2, student_id);
	            i = pst.executeUpdate();
	            if(i!=0)  
	                System.out.println("\nUpdated successfully!!!\n");
	            break;
	            
	        case 4 :    
	            System.out.println("Enter the Student ID : ");
	            student_id=sc.nextInt();
	            String str = "delete from students_details where student_id=?";
	            PreparedStatement pst1 = con.prepareStatement(str); 
	            pst1.setInt(1, student_id);
	            i = pst1.executeUpdate();
	            if(i!=0)  
	                System.out.println("\nDeleted successfully!!!\n");
	            break;
	            
	        default:
	            System.out.printf("You have entered wrong Option !! Please Choose only from above options");
	            break; 
	            
	        }
	        
	    }
	    while(ch!=5);
	            

	}

}

    
    
   
        
    
        
    
        
    
    
       
    
   
        
         
        
        
        


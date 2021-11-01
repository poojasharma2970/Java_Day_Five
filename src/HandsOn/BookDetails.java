package HandsOn;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class BookDetails {

    public static void main(String[] args) throws ClassNotFoundException,SQLException {
        
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
        int book_id;
        String book_name;
        String author_name;
        String publisher_name;
        int price;
        
        switch(ch) {
        case 1:
            String str1="select * from book_details";
            Statement st1=con.createStatement();
            ResultSet rs= st1.executeQuery(str1);
            System.out.println("book_id\tbook_name\tauthor_name\tpublisher_name\tprice");
            while(rs.next()) {
                System.out.print(rs.getInt(1)+"\t");
                System.out.print(rs.getString(2)+"\t");
                System.out.print(rs.getString(3)+"\t");
                System.out.print(rs.getString(4)+"\t");
                System.out.print(rs.getInt(5)+"\t");
                System.out.println();
            }
            break;
            
        case 2 :
            System.out.println("Enter book_id No : ");
            book_id=sc.nextInt();
            System.out.println("Enter the book_name : "); 
            sc.nextLine();
            book_name=sc.nextLine();
            System.out.println("Enter the author_name : ");
            author_name=sc.nextLine();
            System.out.println("Enter the publisher_name : ");
            publisher_name=sc.nextLine();
            System.out.println("Enter the price : ");
            price=sc.nextInt();
            String str2="insert into book_details values('"+book_id+"','"+book_name+"','"+author_name+"','"+publisher_name+"','"+price+"')";
            Statement st=con.createStatement();
            int i=st.executeUpdate(str2);
            if(i!=0) 
                System.out.println("\nInserted successfully!!!\n");
            break;
            
        case 3 :
            System.out.println("Enter the book_id No : ");
            book_id=sc.nextInt();
            System.out.println("Enter the book_name : ");
            book_name=sc.next();
            String str3 = "update book_details set book_name=? where book_id=?";
            PreparedStatement pst = con.prepareStatement(str3);
            pst.setString(1, book_name);
            pst.setInt(2, book_id);
            i = pst.executeUpdate();
            if(i!=0)  
                System.out.println("\nUpdated successfully!!!\n");
            break;
            
        case 4 :    
            System.out.println("Enter the book_id No : ");
            book_id=sc.nextInt();
            String str = "delete from book_details where book_id=?";
            PreparedStatement pst1 = con.prepareStatement(str); 
            pst1.setInt(1, book_id);
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
 
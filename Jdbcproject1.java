package JDBC0428.Assignments;

import java.sql.*;
import java.util.Scanner;
public class Jdbcproject1 {
    public static void main(String args[]) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        System.out.println("Driver loaded successfully");
        Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","Rex!6465");
        System.out.println("Data base connectivity successful");
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter query to be executed: ");
         String x=sc.next();
        PreparedStatement pst=con.prepareStatement(x);
        if(x.contains("select") ) {
            ResultSet rs = pst.executeQuery();
            System.out.println("Employee_id" + " \t\t" + "Employee_name");
            while (rs.next()) {
                System.out.println("\t\t" + rs.getString(2));
                System.out.println();
            }
        }
        else if (x.contains("insert"))
        {
            int y=pst.executeUpdate();
            if(y>0)
            {
                System.out.println("Updated details");
            }

        }
        else if (x.contains("delete"))
        {
            int y=pst.executeUpdate();
            if(y>0)
                System.out.println("employees deleted");
        }

    }
}


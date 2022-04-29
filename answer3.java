package JDBC0428.Assignments;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class answer3 {
    public static void main(String args[]) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        System.out.println("Driver loaded successfully");
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "Rex!6465");
        System.out.println("Data base connectivity successful");
        try {
            Statement stmt = con.createStatement();
            String sql = "CREATE DATABASE abc";
            stmt.executeUpdate(sql);
            System.out.println("Database created successfully...");

            /// droping data base
            sql = "DROP DATABASE employees";
            stmt.executeUpdate(sql);
            System.out.println("Database dropped successfully...");
        }
     catch(SQLException e){
            e.printStackTrace();
        }
    }
}


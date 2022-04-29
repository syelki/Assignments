package JDBC0428.Assignments;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class answer5 {


    public static void main(String args[]) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        System.out.println("Driver loaded successfully");
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "Rex!6465");
        System.out.println("Data base connectivity successful");
        try {
            Statement stmt = con.createStatement();
            System.out.println("Inserting records into the table...");
            String sql = "INSERT INTO Employees2 VALUES (100, 'John', 'Doe', 18)";
            stmt.executeUpdate(sql);
            sql = "INSERT INTO Employees2 VALUES (101, 'Ron', 'Man', 25)";
            stmt.executeUpdate(sql);
            sql = "INSERT INTO Employees2 VALUES (102, 'Angel', 'Raefal', 30)";
            stmt.executeUpdate(sql);
            sql = "INSERT INTO Employees2 VALUES(103, 'michele', 'angel', 28)";
            stmt.executeUpdate(sql);
            System.out.println("Inserted records into the table...");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
package JDBC0428.Assignments;

import java.sql.*;

public class answer7 {
    static final String s = "SELECT * FROM employees2";

    public static void main(String args[]) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        System.out.println("Driver loaded successfully");
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "Rex!6465");
        System.out.println("Data base connectivity successful");
        try {
            Statement stmt = con.createStatement();

            String sql = "UPDATE employees2 " +
                    "SET age = 30 WHERE id in (100, 101)";
            stmt.executeUpdate(sql);
            ResultSet rs = stmt.executeQuery(s);
            while (rs.next()) {
                //Display values
                System.out.print("ID: " + rs.getInt("id"));
                System.out.print(", Age: " + rs.getInt("age"));
                System.out.print(", First: " + rs.getString("first"));
                System.out.println(", Last: " + rs.getString("last"));
            }
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
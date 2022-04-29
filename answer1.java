package JDBC0428.Assignments;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class answer1 {

    public static void main(String[] args) throws SQLException {
        Statement statement = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Driver loaded successfully");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "Rex!6465");
            statement = con.createStatement();
            statement.addBatch("update orders set Employee_name='shravya' where Employee_id=123;");
            statement.addBatch("update orders set Employee_name='Neena' where Employee_id= 234;");
            statement.addBatch("update orders set Employee_name='Aman' where Employee_id=789;");

            int[] x = statement.executeBatch();
            System.out.println("updated records successfully");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } finally {
            if (statement != null)
                statement.close();
        }
    }
}
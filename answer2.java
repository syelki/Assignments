package JDBC0428.Assignments;

import java.sql.*;

public class answer2 {
    public static void main(String[] args) throws SQLException {
        String sql="select * from orders;";
        Statement statement = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Driver loaded successfully");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "Rex!6465");
            PreparedStatement  st=con.prepareStatement(sql,ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
            ResultSet rs = st.executeQuery();
            System.out.println("RECORDS IN THE TABLE...");
            while (rs.next()) {
                System.out.println(rs.getInt(1) + " -> " + rs.getString(2));
            }
            rs.first();
            System.out.println("FIRST RECORD...");
            System.out.println(rs.getInt(1) + " -> " + rs.getString(2));
            rs.absolute(3);
            System.out.println("THIRD RECORD...");
            System.out.println(rs.getInt(1) + " -> " + rs.getString(2));
            rs.last();
            System.out.println("LAST RECORD...");
            System.out.println(rs.getInt(1) + " -> " + rs.getString(2));
            rs.previous();
            rs.relative(-1);
            System.out.println("LAST TO FIRST RECORD...");
            System.out.println(rs.getInt(1) + " -> " + rs.getString(2));
            con.close();

        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
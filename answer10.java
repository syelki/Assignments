package JDBC0428.Assignments;

import java.sql.*;
//Q1. CREATE APPLICATION THAT ASK USER TO ENTER TABLE NAME THEN YOU HAVE TO PROVIDE ALL TE INFOR ABOUT TABLE USING rESULTsetmeta DATA
public class answer10 {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        System.out.println("Driver loaded successfully");
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test" , "root" , "Rex!6465");
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery("select * from orders;");
        ResultSetMetaData rsmd=rs.getMetaData();
        for (int i=0;i<rsmd.getColumnCount();i++)
        {
            System.out.println(rsmd.getColumnName(i+1));
            System.out.println("\t"+rsmd.getColumnTypeName(i+1));
            System.out.println(rsmd.getColumnName(i+1));

        }
    }
}

package day0429Assignments;

import java.sql.*;
import java.util.Scanner;
import static java.lang.System.in;
import static java.lang.System.out;
//Q1-create an application that ask user to enter the table name then you ahve to provide all teh info about the table using Resultsetmetadata
class MetaDataDemo
{
        public static void main(String[] args) throws SQLException, ClassNotFoundException {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Driver loaded successfully");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "Rex!6465");
            MetaDataDemo r = new MetaDataDemo();
            out.println("Insert Table name ?");
            Scanner sc = new Scanner(in);
            String tablename = sc.next();

            try {
                Statement st = con.createStatement();
                ResultSet rs = st.executeQuery("select * from "+tablename);
                ResultSetMetaData rsmd = rs.getMetaData();
                for (int i = 1; i < rsmd.getColumnCount(); i++) {
                    out.println("Table Name : "+rsmd.getTableName(i)+"\t");
                    out.print(rsmd.getColumnName(i)+"\t");
                    out.print(rsmd.getColumnTypeName(i)+"\t");
                }
                while (rs.next())
                {
                    String name = rs.getString(1);
                    String price = rs.getString(2);
                    out.println("name : "+name+" price : "+price);
                }

            } catch (Exception e) {
                throw new RuntimeException(e);
            }



        }

    }


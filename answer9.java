package JDBC0428.Assignments;


import java.io.*;
import java.sql.*;
public class answer9 {
      public static void main(String args[]) throws ClassNotFoundException, SQLException {
                    Class.forName("com.mysql.cj.jdbc.Driver");
                    System.out.println("Driver loaded successfully");
                    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "Rex!6465");
                    System.out.println("Data base connectivity successful");
                    try {
  Statement     st = con.createStatement();
                        ResultSet      rs = st.executeQuery("select * from orders ;");

               FileInputStream  is = new FileInputStream(new File("C:\\Users\\17329\\Desktop\\download (1).jpg"));
               OutputStream    os = new FileOutputStream("output.jpg");
                        if(rs.next()){
                            is = (FileInputStream) rs.getBinaryStream(1);
                        }
                byte[] content = new byte[1024];
                int size = 0;
                while((size = is.read(content)) != -1){
                    os.write(content, 0, size);
                }
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            } catch (FileNotFoundException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
                }

    }





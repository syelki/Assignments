package JDBC0428.Assignments;

    import java.sql.*;


public class answer8 {
        public static void main(String[] args) throws Exception {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Driver loaded successfully");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "Rex!6465");
            System.out.println("Data base connectivity successful");
                       Statement stmt = con.createStatement();
            String query1 = "insert into emp values(5,'name','job')";
            String query2 = "select * from emp";

            con.setAutoCommit(false);
            Savepoint spt1 = con.setSavepoint("svpt1");
            stmt.execute(query1);
            ResultSet rs = stmt.executeQuery(query2);
            int no_of_rows = 0;

            while (rs.next()) {
                no_of_rows++;
            }
            System.out.println("rows before rollback statement = " + no_of_rows);
            con.rollback(spt1);
            con.commit();
            no_of_rows = 0;
            rs = stmt.executeQuery(query2);

            while (rs.next()) {
                no_of_rows++;
            }
            System.out.println("rows after rollback statement = " + no_of_rows);
        }
    }

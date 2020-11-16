package DBConnection;

import java.sql.*;
import java.util.Scanner;

public class DBConnection {
    int port = 5432;
    final String User = "postgres";
    final String Password = "hAppyF45F@2";
    String name;

    Scanner input = new Scanner(System.in);



    public void accountTest() throws SQLException{
        try(Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/AccountInfo?serverTimezone=UTC", User, Password)){
            System.out.println("Connected");

            System.out.println("What is your firstname");
            String fname = input.nextLine();

            System.out.println("What is your last name");
            String lname = input.nextLine();

            System.out.println("What is your email");
            String email = input.nextLine();

            //        Account num
            long ranNum = (long)(Math.random() + 6 * 58 + 4);



            String sql = "INSERT into customerinfo(first_name, last_name, email, account_number)" + "values(?,?,?,?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, fname);
            ps.setString(2, lname);
            ps.setString(3, email);
            ps.setLong(4, 950);
            ps.execute();
        }
    }

    public void dbConnection() throws SQLException {
        try(Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/AccountInfo?serverTimezone=UTC", User, Password)){
            System.out.println("Connected");
        }catch(SQLException e){
            System.err.println("Error");
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws SQLException {
        DBConnection db = new DBConnection();
        db.accountTest();

    }

}

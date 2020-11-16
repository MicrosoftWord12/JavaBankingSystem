package DBConnection;

import java.sql.*;
import java.util.Scanner;

public class DBConnection {
    int port = 5432;
    final String User = "postgres";
    final String Password = "hAppyF45F@2";
    String name;

    Scanner input = new Scanner(System.in);



//    public void accountTest() throws SQLException{
//        System.out.println("What is your firstname");
//    }

    public void dbConnection() throws SQLException {
        try(Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/AccountInfo?serverTimezone=UTC", User, Password)){

            String sql = "SELECT first_name from customerinfo where first_name = '" + name + "'";
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
        }catch(SQLException e){
            System.err.println("Error");
            e.printStackTrace();
        }
    }

//    public static void main(String[] args) throws SQLException {
//
//
//    }

}

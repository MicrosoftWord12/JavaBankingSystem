package DBConnection;

import java.sql.*;
import java.util.Scanner;

public class DBConnection {

    int port = 5432;
    final String User = "postgres";
    final String Password = "hAppyF45F@2";
    String firstName;
    String name;


    Scanner input = new Scanner(System.in);

    public String getFirstName() throws SQLException{
        Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/AccountInfo?serverTimezone=UTC", User, Password);
        String sql = "select first_name where first_name ='" + firstName + "'";
        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery(sql);
        while (rs.next()) {
            String fName = rs.getString(1);
            System.out.printf("%s", fName);
            return fName;

        }
        return firstName;
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

    }

}

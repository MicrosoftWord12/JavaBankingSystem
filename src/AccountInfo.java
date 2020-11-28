import DBConnection.DBConnection;

import java.io.*;
import java.sql.*;
import java.util.Scanner;

public class AccountInfo{
//    Classes
    DBConnection db = new DBConnection();


    private String firstName;
    private String lastName;
    private String emailAddress;
    private long accountNo;
    private double balance;
    private final String fileName = "D:\\JavaBankingSystem\\accountsDB.txt";
//    DB stuff
    protected final String User = "postgres";
    protected final String Password = "hAppyF45F@2";


    public AccountInfo(String firstName, String lastName, String emailAddress, int accountNo) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.emailAddress = emailAddress;
        this.accountNo = accountNo;
    }

    public AccountInfo() {
    }

    public String getFirstName() throws SQLException{
//        Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/AccountInfo?serverTimezone=UTC", User, Password);
//        String sql = "select first_name from customerinfo where first_name ='" + firstName + "'";
//        Statement st = conn.createStatement();
//        ResultSet rs = st.executeQuery(sql);
//        while (rs.next()) {
//            String fName = rs.getString("first_name");
//            System.out.printf("%s", fName);
//        }
        return firstName;
    }

    public void setFirstName(String firstName) throws SQLException {
        this.firstName = firstName;

//        String sql = "insert into customerinfo(first_name)" + "values(?)";
//        Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/AccountInfo?serverTimezone=UTC", User, Password);
//        PreparedStatement ps = conn.prepareStatement(sql);
//        ps.setString(1, firstName);
//        ps.execute();



    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) throws SQLException{
        this.balance = balance;

//        String sql = "insert into customerinfo(balance)" + "values(?)";
//        Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/AccountInfo?serverTimezone=UTC", User, Password);
//        PreparedStatement ps = conn.prepareStatement(sql);
//        ps.setDouble(1, balance);
//        ps.execute();

    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) throws SQLException {
        this.lastName = lastName;

//        String sql = "insert into customerinfo(last_name)" + "values(?)";
//        Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/AccountInfo?serverTimezone=UTC", User, Password);
//        PreparedStatement ps = conn.prepareStatement(sql);
//        ps.setString(1, lastName);
//        ps.execute();

    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) throws SQLException{
        this.emailAddress = emailAddress;

        // String sql = "insert into customerinfo(email)" + "values(?)";
        // Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/AccountInfo?serverTimezone=UTC", User, Password);
        // PreparedStatement ps = conn.prepareStatement(sql);
        // ps.setString(1, lastName);
        // ps.execute();
    }

    public long getAccountNo() {
        return accountNo;
    }

    public void setAccountNo(long accountNo) throws SQLException{
        this.accountNo = accountNo;

        // String sql = "insert into customerinfo(account_number)" + "values(?)";
        // Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/AccountInfo?serverTimezone=UTC", User, Password);
        // PreparedStatement ps = conn.prepareStatement(sql);
        // ps.setLong(1, accountNo);
        // ps.execute();
    }

    @Override
    public String toString() {
        return "AccountInfo{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", emailAddress='" + emailAddress + '\'' +
                ", accountNo=" + accountNo +
                '}';
    }

    public void load(String firstName, String lastName, String email, long accountNO, double balance) throws SQLException{
        Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/AccountInfo?serverTimezone=UTC", User, Password);
        String fNameSQL = "select first_name where first_name =''" + firstName + "'";
        String lNameSQL = "select last_name where last_name ='" + lastName + "'";
        String emailSQL = "select email where email = '" + email + "''";
        String accountNOSQL = "select account_number where account_number = '" +  accountNo + "'";
        String balanceSQL = "select balance where balance ='" + balance + "'";
    }

    public void save(String firstName, String lastName, String email, long accountNO, double balance) throws SQLException{
        Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/AccountInfo?serverTimezone=UTC", User, Password);
        String sql = "insert into customerinfo()" + "VALUES(?,?,?,?,?)";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1, firstName);
        ps.setString(2, lastName);
        ps.setString(3, email);
        ps.setLong(4, accountNO);
        ps.setDouble(5, balance);

    }



    public void getAll() throws SQLException {
        getAccountNo();
        getBalance();
        getFirstName();
        getLastName();
        getEmailAddress();
    }

//    public void save() throws IOException {
//        try (FileWriter fw = new FileWriter(fileName);
//             BufferedWriter bw = new BufferedWriter(fw);
//             PrintWriter outfile = new PrintWriter(bw)) {
//
//            outfile.println(getFirstName());
//            outfile.println(getLastName());
//            outfile.println(getEmailAddress());
//            outfile.println(getBalance());
//            outfile.println(getAccountNo());
//            outfile.close();
//        }
//    }

//    public void load() throws IOException, SQLException {
//        try (FileReader fr = new FileReader(fileName);
//             BufferedReader br = new BufferedReader(fr);
//             Scanner infile = new Scanner(br)) {
//
//            infile.useDelimiter("\r?\n|\r"); //End of line characters on Unix or DOS or others OSs
//
//            if (!infile.hasNext()) {
//                System.err.println("File is empty");
//            }
//            while (infile.hasNext()) {
//                setFirstName(infile.nextLine());
//                setLastName(infile.nextLine());
//                setEmailAddress(infile.nextLine());
//                setBalance(infile.nextDouble());
//                setAccountNo(infile.nextLong());
//            }
//        }
//    }
}

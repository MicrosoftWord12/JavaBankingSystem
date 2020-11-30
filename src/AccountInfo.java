import DBConnection.DBConnection;

import java.sql.*;


public class AccountInfo{
//    Classes
    DBConnection db = new DBConnection();


    private String firstName;
    private String lastName;
    private String emailAddress;
    private long accountNo;
    private double balance;
    // private final String fileName = "D:\\JavaBankingSystem\\accountsDB.txt";
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

    public String getFirstName(){
        return firstName;
    }

    public void setFirstName(String firstName){
        this.firstName = firstName;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance){
        this.balance = balance;
    }

    public String getLastName(){
        return lastName;
    }

    public void setLastName(String lastName){
        this.lastName = lastName;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress){
        this.emailAddress = emailAddress;
    }

    public long getAccountNo() {
        return accountNo;
    }

    public void setAccountNo(long accountNo) throws SQLException{
        this.accountNo = accountNo;
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

    public void load(String firstName, String lastName, String email, long accountNO) throws SQLException{
        Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/AccountInfo?serverTimezone=UTC", User, Password);
        String fNameSQL = "select first_name from customerinfo where first_name ='" + firstName + "'";
        String lNameSQL = "select last_name from customerinfo where last_name ='" + lastName + "'";
        String emailSQL = "select email from customerinfo where email = '" + email + "'";
        String accountNoSQL = "select account_number from customerinfo where account_number = '" +  accountNO + "'";
        String balanceSQL = "select balance from customerinfo where account_number =" + accountNO + "";

        Statement fNameST = conn.createStatement();
        ResultSet fNameRS = fNameST.executeQuery(fNameSQL);

        Statement lNameST = conn.createStatement();
        ResultSet lNameRS = lNameST.executeQuery(lNameSQL);

        Statement emailST = conn.createStatement();
        ResultSet emailRS = emailST.executeQuery(emailSQL);

        Statement accountNoST = conn.createStatement();
        ResultSet accountNoRS = accountNoST.executeQuery(accountNoSQL);

        Statement balanceST = conn.createStatement();
        ResultSet balanceRS = balanceST.executeQuery(balanceSQL);

        if (fNameRS.isBeforeFirst()){
            while(fNameRS.next() && lNameRS.next() && emailRS.next() && accountNoRS.next() && balanceRS.next()){
                String fName = fNameRS.getString("first_name");
                String lName = lNameRS.getString("last_name");
                String emailAnswer = emailRS.getString("email");
                long accountNumber = accountNoRS.getLong("account_number");
                double balanceAnswer = balanceRS.getDouble("balance");
                System.out.printf("First name = %s, Last Name = %s, Email = %s, Account Number = %s, Balance = £%s", fName, lName, emailAnswer, accountNumber, balanceAnswer);
            }
        }else{
            System.err.println("Error has occured");
            System.out.println("The inputs are not in the database");
        }

    }

    public void save(String firstName, String lastName, String email, long accountNO, double balance) throws SQLException{
        Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/AccountInfo?serverTimezone=UTC", User, Password);
        String sql = "insert into customerinfo(first_name, last_name, email, account_number, balance)" + "VALUES(?,?,?,?,?)";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1, firstName);
        ps.setString(2, lastName);
        ps.setString(3, email);
        ps.setLong(4, accountNO);
        ps.setDouble(5, balance);
        ps.execute();
    }

    public void viewAccount(String email, long accountNo) throws SQLException{
        Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/AccountInfo?serverTimezone=UTC", User, Password);

        String emailSQL = "select email from customerinfo where email = '" + email + "'";
        String accountNoSQL = "select account_number from customerinfo where account_number = '" + accountNo + "'";
        String balanceSQL = "select balance from customerinfo where account_number = '" + accountNo + "'";

        Statement emailST = conn.createStatement();
        ResultSet emailRS = emailST.executeQuery(emailSQL);

        Statement accountNoST = conn.createStatement();
        ResultSet accountNoRS = accountNoST.executeQuery(accountNoSQL);

        Statement balanceST = conn.createStatement();
        ResultSet balanceRS = balanceST.executeQuery(balanceSQL);

        if (emailRS.isBeforeFirst()){
            while (emailRS.next() && accountNoRS.next() && balanceRS.next()){
                String emailAns = emailRS.getString("email");
                long accountNoAns = accountNoRS.getLong("account_number");
                double balanceAns = balanceRS.getDouble("balance");
                System.out.printf("Email = %s, Account Number = %s, Balance = £%s", emailAns, accountNoAns, balanceAns);
            }
        }

    }

    public void addFunds(long accountNumber, double balance) throws SQLException{
        Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/AccountInfo?serverTimezone=UTC", User, Password);

        String accountNoSQL = "select account_number from customerinfo where account_number = '" + accountNumber + "'";
        // String currentBal = "select balance from customerinfo where account_number = '" + accountNumber + "'";


        Statement accountNoST = conn.createStatement();
        ResultSet accountNoRS = accountNoST.executeQuery(accountNoSQL);

        // Statement currentBalSQL = conn.createStatement();
        // ResultSet currentBalRS = currentBalSQL.executeQuery(currentBal);

        // while(currentBalRS.next()){
        //     beforeBal = currentBalRS.getDouble("balance");
        // }

        if (accountNoRS.next()){
            System.out.println("Working");
            String addfunds = "update customerinfo set balance = balance + ? where account_number = ?";
            PreparedStatement ps = conn.prepareStatement(addfunds);
            ps.setDouble(1, balance);
            ps.setLong(2, accountNumber);
            ps.executeUpdate();
        }else{
            System.out.println("Probably not in database");
        }
    }

    public void viewBalance(String email, long accountNo)throws SQLException{
        Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/AccountInfo?serverTimezone=UTC", User, Password);
        String emailAdd = "select email from customerinfo where email = '" + email + "'";

        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery(emailAdd);

        if (rs.next()){
            String balanceSQL = "select balance from customerinfo where account_number = '" + accountNo + "'";
            Statement balSQL = conn.createStatement();
            ResultSet balRS = balSQL.executeQuery(balanceSQL);
            while(balRS.next()){
                double balance = balRS.getDouble("balance");
                System.out.printf("Your Balance is: %s", balance);
            }

        }else{
            System.out.println("Not in database");
        }
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

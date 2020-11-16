import DBConnection.DBConnection;

import java.io.*;
import java.util.Scanner;

public class AccountInfo {
//    Classes
    DBConnection db = new DBConnection();

    private String firstName;
    private String lastName;
    private String emailAddress;
    private long accountNo;
    private double balance;
    private final String fileName = "D:\\JavaBankingSystem\\accountsDB.txt";


    public AccountInfo(String firstName, String lastName, String emailAddress, int accountNo) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.emailAddress = emailAddress;
        this.accountNo = accountNo;
    }

    public AccountInfo() {
    }

    public String getFirstName() {
        return firstName;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;

        String sql = "insert into customerinfo(first_name)" + "values(?)";


    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public long getAccountNo() {
        return accountNo;
    }

    public void setAccountNo(long accountNo) {
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

    public void save() throws IOException {
        try (FileWriter fw = new FileWriter(fileName);
             BufferedWriter bw = new BufferedWriter(fw);
             PrintWriter outfile = new PrintWriter(bw)) {

            outfile.println(getFirstName());
            outfile.println(getLastName());
            outfile.println(getEmailAddress());
            outfile.println(getBalance());
            outfile.println(getAccountNo());
            outfile.close();
        }
    }

    public void load() throws IOException {
        try (FileReader fr = new FileReader(fileName);
             BufferedReader br = new BufferedReader(fr);
             Scanner infile = new Scanner(br)) {

            infile.useDelimiter("\r?\n|\r"); //End of line characters on Unix or DOS or others OSs

            if (!infile.hasNext()) {
                System.err.println("File is empty");
            }
            while (infile.hasNext()) {
                setFirstName(infile.nextLine());
                setLastName(infile.nextLine());
                setEmailAddress(infile.nextLine());
                setBalance(infile.nextDouble());
                setAccountNo(infile.nextLong());
            }
        }
    }
}

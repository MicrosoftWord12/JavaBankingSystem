import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class AccountInfo {
    private String firstName;
    private String lastName;
    private String emailAddress;
    private long accountNo;
    private double balance;

    public AccountInfo(String firstName, String lastName, String emailAddress, long accountNo) {
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
        String fileName = "accountsDB.txt";
        try (FileWriter fw = new FileWriter(fileName);
             BufferedWriter bw = new BufferedWriter(fw);
             PrintWriter outfile = new PrintWriter(bw)) {

            outfile.println(getFirstName());
            outfile.println(getLastName());
            outfile.println(getEmailAddress());
        }
    }
}

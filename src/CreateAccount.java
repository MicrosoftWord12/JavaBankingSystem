import java.util.ArrayList;

public class CreateAccount{
    private String firstName;
    private String lastName;
    private String emailAddress;
    private double balance;
    private String myName;
    private ArrayList<AccountInfo> accountName;

    public CreateAccount(String firstName, String lastName) {
       this.firstName = firstName;
       this.lastName = lastName;
        accountName = new ArrayList<>();
    }


    public String getFirstName() {
        return firstName;
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

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

}

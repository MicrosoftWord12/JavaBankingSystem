public class CurrentAccount extends AccountInfo {
    private float balance;
    private String makeAccount;

    public CurrentAccount(String firstName, String lastName, String emailAddress, int accountNo) {
        super(firstName, lastName, emailAddress, accountNo);
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(float balance) {
        this.balance = balance;
    }

    public String getAccount(){
        return makeAccount;
    }

    public void setAccount(String makeAccount){
        this.makeAccount = makeAccount;
    }
}

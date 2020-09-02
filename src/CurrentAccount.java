public class CurrentAccount extends AccountInfo {
    private float balance;

    public CurrentAccount(String firstName, String lastName, String emailAddress, long accountNo) {
        super(firstName, lastName, emailAddress, accountNo);
    }

    public float getBalance() {
        return balance;
    }

    public void setBalance(float balance) {
        this.balance = balance;
    }
}

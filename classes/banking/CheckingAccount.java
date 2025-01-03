
public class CheckingAccount extends Account {
    private int overdraftLimit;
    private int overdraftFee;

    public CheckingAccount(int balance, int overdraftLimit, int overdraftFee) {
        super(balance, "Checking");
        this.overdraftLimit = overdraftLimit;
        this.overdraftFee = overdraftFee;
    }

    public boolean makeWithdrawal(int amount) {
        if (getBalance() + overdraftLimit >= amount) {
            removeMoney(amount);
            return true;
        }
        return false;
    }

    public void makeDeposit(int amount) {
        addMoney(amount);
        if (getBalance() - amount < 0 && getBalance() >= overdraftFee) {
            removeMoney(overdraftFee);
        }
    }
}

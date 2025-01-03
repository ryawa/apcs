
public class SavingsAccount extends Account {
    public SavingsAccount(int balance) {
        super(balance, "Savings");
    }

    public boolean makeWithdrawal(int amount) {
        if (getBalance() >= amount) {
            removeMoney(amount);
            return true;
        }
        return false;
    }

    public void makeDeposit(int amount) {
        addMoney(amount);
    }
}

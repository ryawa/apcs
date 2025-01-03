import java.util.ArrayList;

public abstract class Account {
    private int balance;
    private String type;
    private ArrayList<Integer> transactions = new ArrayList<>();

    public Account(int balance, String type) {
        this.balance = balance;
        this.type = type;
    }

    protected void addMoney(int amount) {
        balance += amount;
    }

    protected void removeMoney(int amount) {
        balance -= amount;
    }

    public int getBalance() {
        return balance;
    }

    public String getType() {
        return type;
    }

    public void makeTransaction(String type, int amount) {
        if (type.equals("W") && makeWithdrawal(amount)) {
            System.out.println("Withdrawal completed. New balance is " + balance);
            transactions.add(-amount);
        } else if (type.equals("D")) {
            makeDeposit(amount);
            System.out.println("Deposit completed. New balance is " + balance);
            transactions.add(amount);
        } else {
            System.out.println("Transaction failed, not enough money.");
        }
    }

    public abstract boolean makeWithdrawal(int amount);

    public abstract void makeDeposit(int amount);

    public String getSummary() {
        String res = type + " account:\n";
        for (int transaction : transactions) {
            String action = "Deposited";
            if (transaction < 0) {
                action = "Withdrew";
            }
            action += " $";
            action += Math.abs(transaction);
            action += "\n";
            res += action;
        }
        return res;
    }
}

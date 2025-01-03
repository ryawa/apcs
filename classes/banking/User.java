import java.util.ArrayList;

public class User {
    private String id;
    private String pin;
    private ArrayList<Account> accounts = new ArrayList<>();

    public User(String id, String pin) {
        this.id = id;
        this.pin = pin;
    }

    public void addAccount(Account account) {
        accounts.add(account);
    }

    public ArrayList<Account> getAccounts() {
        return accounts;
    }

    public String getId() {
        return id;
    }

    public boolean login(String pin) {
        return this.pin.equals(pin);
    }

    public Account getAccount(String type) {
        Account a = null;
        for (Account account : accounts) {
            if (account.getType().charAt(0) == type.charAt(0)) {
                a = account;
            }
        }
        return a;
    }

    public void printSummary() {
        for (Account account : accounts) {
            System.out.print(account.getSummary());
        }
    }
}

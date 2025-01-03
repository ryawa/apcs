import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        HashMap<String, User> users = new HashMap<>();
        User u1 = new User("12345", "8613");
        u1.addAccount(new SavingsAccount(500));
        User u2 = new User("11111", "1111");
        u2.addAccount(new SavingsAccount(300));
        u2.addAccount(new CheckingAccount(20, 10, 30));
        users.put(u1.getId(), u1);
        users.put(u2.getId(), u2);

        Scanner s = new Scanner(System.in);
        User user = login(s, users);

        while (true) {
            String transactionType = getTransactionType(s);
            if (transactionType.equals("P")) {
                user.printSummary();
            } else if ("CS".contains(transactionType)) {
                while (true) {
                    String actionType = getActionType(s);
                    if (actionType.equals("C")) {
                        break;
                    }

                    Account account = user.getAccount(transactionType);
                    if (account == null) {
                        System.out.println("Invalid option");
                        continue;
                    }

                    System.out.print("Enter amount: ");
                    int amount = s.nextInt();
                    account.makeTransaction(actionType, amount);
                }
            } else if (transactionType.equals("Q")) {
                break;
            }
        }
        s.close();
    }

    public static User login(Scanner s, HashMap<String, User> users) {
        String id = "";
        String pin = "";
        while (users.get(id) == null || !users.get(id).login(pin)) {
            System.out.print("Account ID and secret PIN: ");
            id = s.next().trim();
            pin = s.next().trim();
        }
        return users.get(id);
    }

    public static String getTransactionType(Scanner s) {
        String transactionType;
        while (true) {
            System.out.println("Please select a transaction: ");
            System.out.println("P (Obtain a Summary Statement)");
            System.out.println("S (Process a Savings Transaction)");
            System.out.println("C (Process a Checking Transaction)");
            System.out.println("Q (Quit)");

            ArrayList<String> validOptions = new ArrayList<>();
            validOptions.add("P");
            validOptions.add("S");
            validOptions.add("C");
            validOptions.add("Q");

            transactionType = s.next().trim();
            if (validOptions.contains(transactionType)) {
                break;
            }
        }
        return transactionType;
    }

    public static String getActionType(Scanner s) {
        String actionType;
        while (true) {
            System.out.println("D (Process a Deposit)");
            System.out.println("W (Process a Withdrawal)");
            System.out.println("C (Cancel)");

            ArrayList<String> validOptions = new ArrayList<>();
            validOptions.add("D");
            validOptions.add("W");
            validOptions.add("C");

            actionType = s.next().trim();
            if (validOptions.contains(actionType)) {
                break;
            }
        }
        return actionType;
    }
}

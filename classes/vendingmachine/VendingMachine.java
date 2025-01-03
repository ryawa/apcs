import java.util.HashMap;

public class VendingMachine {
    private double moneyInserted = 0;
    private HashMap<String, Integer> inventory = new HashMap<>();

    public VendingMachine(String[] brands, int count) {
        for (String brand : brands) {
            inventory.put(brand, count);
        }
    }

    public void addMoney(double amount) {
        moneyInserted += amount;
    }

    public void buyDrink(String brand) {
        if (inventory.containsKey(brand) && inventory.get(brand) > 0) {
            if (moneyInserted >= 2) {
                moneyInserted -= 2;
                inventory.put(brand, inventory.get(brand) - 1);
                System.out.println("Bought " + brand);
                System.out.println("Change: " + moneyInserted);
                moneyInserted = 0;
            } else {
                System.out.println("Not enough money");
            }
        } else {
            System.out.println("Brand not available");
        }
    }

    public double restart() {
        double m = moneyInserted;
        moneyInserted = 0;
        return m;
    }

    public void printInventory() {
        for (String brand : inventory.keySet()) {
            System.out.println(brand + ": " + inventory.get(brand));
        }
    }

    public void restock(String brand, int count) {
        inventory.put(brand, inventory.get(brand) + count);
    }
}

public class Main {
    public static void main(String[] args) {
        VendingMachine machine = new VendingMachine(new String[] { "Pepsi", "Coca-cola" }, 10);
        machine.addMoney(1);
        machine.buyDrink("Pepsi");
        machine.addMoney(2);
        machine.buyDrink("Pepsi");
        machine.restart();
        machine.printInventory();
        machine.restock("Pepsi", 50);
        machine.printInventory();
    }
}

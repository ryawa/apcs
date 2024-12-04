public class Apartment extends Building {
    private double costPerFloor;
    private double totalCost;

    public Apartment(double costPerFloor) {
        this.costPerFloor = costPerFloor;
    }

    public double getCostPerFloor() {
        return costPerFloor;
    }

    public double getTotalCost() {
        return totalCost;
    }

    public void calcCost(double taxAmount) {
        totalCost = costPerFloor * getFloors() + taxAmount;
    }

    public String toString() {
        return "" + totalCost;
    }
}

public class Apartment extends Building {
    private double costPerFloor;

    public Apartment(double costPerFloor) {
        this.costPerFloor = costPerFloor;
    }

    public double getCostPerFloor() {
        return costPerFloor;
    }

    public void calcCost(double taxAmount) {
        setTotalCost(costPerFloor * getFloors() + taxAmount);
    }
}

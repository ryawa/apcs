public class OfficeSpace extends Building {
    private double costPerFloor;
    private double squareFeetPerFloor;
    private double totalCost;

    public OfficeSpace(double costPerFloor, double squareFeetPerFloor) {
        this.costPerFloor = costPerFloor;
        this.squareFeetPerFloor = squareFeetPerFloor;
    }

    public double getCostPerFloor() {
        return costPerFloor;
    }

    public double getSquareFeetPerFloor() {
        return squareFeetPerFloor;
    }

    public double getTotalCost() {
        return totalCost;
    }

    public void calcCost(double taxAmount) {
        totalCost = costPerFloor * getFloors() + taxAmount + squareFeetPerFloor * 2.75;
    }

    public String toString() {
        return "" + totalCost;
    }
}

public class OfficeSpace extends Building {
    private double costPerFloor;
    private double squareFeetPerFloor;

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

    public void calcCost(double taxAmount) {
        setTotalCost(costPerFloor * getFloors() + taxAmount + squareFeetPerFloor * 2.75);
    }
}

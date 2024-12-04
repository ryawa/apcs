public abstract class Building {
    private int floors = 5;
    private double totalCost;

    public int getFloors() {
        return floors;
    }

    public void setFloors(int floors) {
        this.floors = floors;
    }

    public abstract void calcCost(double taxAmount);

    public double getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(double totalCost) {
        this.totalCost = totalCost;
    }

    public String toString() {
        return "" + totalCost;
    }
}

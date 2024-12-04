public abstract class Building {
    private int floors = 5;

    public int getFloors() {
        return floors;
    }

    public void setFloors(int floors) {
        this.floors = floors;
    }

    public abstract void calcCost(double taxAmount);
}

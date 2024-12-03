public class Car {
    private int year;
    private String make;
    private String model;

    public Car(int year, String make, String model) {
        this.year = year;
        this.make = make;
        this.model = model;
    }

    public int getYear() {
        return year;
    }

    public String getMake() {
        return make;
    }

    public String getModel() {
        return model;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String toString() {
        return "" + year + " " + make + " " + model;
    }
}

public class Main {
    public static void main(String[] args) {
        Building b = new Apartment(15.5);
        b.calcCost(12.5);
        System.out.println(b.toString());

        Building c = new OfficeSpace(15, 20);
        c.calcCost(10);
        System.out.println(c.toString());
    }
}

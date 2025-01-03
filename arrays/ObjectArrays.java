public class ObjectArrays {
    public static void main(String[] args) {
        Car[] cars = new Car[3];
        cars[0] = new Car(2020, "Ford", "F-150");
        cars[1] = new Car(2017, "Toyota", "Prius");
        cars[2] = new Car(2019, "Honda", "Civic");
        for (int i = 0; i < cars.length; i++) {
            System.out.println(cars[i]);
        }
        System.out.println();

        modifyArray(cars);
        for (int i = 0; i < cars.length; i++) {
            System.out.println(cars[i]);
        }
        System.out.println();

        reallocateArray(cars);
        for (int i = 0; i < cars.length; i++) {
            System.out.println(cars[i]);
        }
        System.out.println();
    }

    private static void modifyArray(Car[] arr) {
        arr[0] = new Car(2023, "Tesla", "Cybertruck");
        for (int i = 1; i < arr.length; i++) {
            if (arr[i].getMake().equals("Toyota")) {
                arr[i].setModel("Highlander");
            }
        }
    }

    private static void reallocateArray(Car[] arr) {
        arr = new Car[3];
        arr[0] = new Car(2020, "Ford", "F-150");
        arr[1] = new Car(2017, "Toyota", "Prius");
        arr[2] = new Car(2019, "Honda", "Civic");
    }
}

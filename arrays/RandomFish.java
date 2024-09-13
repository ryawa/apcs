public class RandomFish {
    public static void main(String[] args) {
        int size = (int) (Math.random() * 20) + 1;
        Fish[] fishes = new Fish[size];
        String[] names = { "Salmon", "Sardines", "Bass", "Swordfish" };

        for (int i = 0; i < size; i++) {
            String name = names[(int) (Math.random() * names.length)];
            int length = (int) (Math.random() * 20) + 1;
            fishes[i] = new Fish(name, length);
            System.out.println(fishes[i]);
        }
        System.out.println();

        for (int i = 0; i < size; i++) {
            if (fishes[i].getLength() > 10) {
                fishes[i].setName("Tuna");
            }
            System.out.println(fishes[i]);
        }
    }
}

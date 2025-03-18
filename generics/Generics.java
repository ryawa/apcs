public class Generics {
    public static void main(String[] args) {
        Container<Integer> c = new Container<Integer>();
        c.add(1);
        c.add(6);
        c.add(4);
        c.remove(1);
        for (int x : c) {
            System.out.print(x + " ");
        }
        System.out.println();
    }
}

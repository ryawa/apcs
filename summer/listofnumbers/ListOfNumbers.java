import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ListOfNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> randomNumbers = new ArrayList<Integer>();
        int count = scanner.nextInt();
        for (int i = 0; i < count; i++) {
            randomNumbers.add((int) (Math.random() * 20) + 1);
        }
        scanner.close();

        int min = randomNumbers.get(0);
        int max = min;
        int mode = min;
        int modeCount = 1;
        int[] counts = new int[20];

        for (int i = 0; i < randomNumbers.size(); i++) {
            int n = randomNumbers.get(i);
            if (n < min) {
                min = n;
            } else if (n > max) {
                max = n;
            }

            counts[n - 1]++;
            if (counts[n - 1] > modeCount) {
                mode = n;
                modeCount = counts[n - 1];
            }

            System.out.println(randomNumbers.get(i));
        }
        System.out.println("Lowest is " + min);
        System.out.println("Highest is " + max);
        System.out.println("Most frequent is " + mode + " and appears " + modeCount + " times");
    }
}

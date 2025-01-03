import java.util.HashMap;

public class SortAll<T> {
    public static <T extends Comparable<T>> void bubbleSort(T a[], boolean descending) {
        for (int i = a.length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if ((a[j].compareTo(a[j + 1]) > 0) ^ descending) {
                    T temp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = temp;
                }
            }
        }
    };

    public static <T> HashMap<T, Integer> findDuplicates(T a[]) {
        HashMap<T, Integer> duplicates = new HashMap<>();
        T prev = a[0];
        for (int i = 1; i < a.length; i++) {
            if (a[i].equals(prev)) {
                duplicates.put(a[i], duplicates.getOrDefault(a[i], 1) + 1);
            }
            prev = a[i];
        }
        return duplicates;
    }
}

import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        String[] arr = { "a", "bsadfjlskfd", "c", "zfw", "c", "c", "a" };
        SortAll.bubbleSort(arr, true);
        for (String s : arr) {
            System.out.println(s);
        }
        HashMap<String, Integer> duplicates = SortAll.findDuplicates(arr);
        for (String key : duplicates.keySet()) {
            System.out.println(key + ": " + duplicates.get(key) + " times");
        }
    }
}

import java.util.Arrays;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class Poe {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File("poemodified.txt"));
        scanner.useDelimiter("[-;\\s]+");

        int wordCount = 0;
        HashMap<String, Integer> wordMap = new HashMap<String, Integer>();
        String mode = null;
        int modeCount = 0;

        while (scanner.hasNext()) {
            String word = scanner.next().toLowerCase();
            int newCount = wordMap.getOrDefault(word, 0) + 1;
            wordMap.put(word, newCount);
            if (newCount > modeCount) {
                mode = word;
                modeCount = newCount;
            }
            wordCount++;
        }
        scanner.close();

        System.out.println("The total number of words in poemodified.txt is: " + wordCount);
        System.out.println("The number of unique words is: " + wordMap.size());
        System.out.println(mode + " is the most frequent word and it occurs " + modeCount + " times");
        System.out.println();

        PrintWriter pw = new PrintWriter(new File("counts.txt"));
        List<WordCount> counts = new ArrayList<WordCount>();
        for (String word : wordMap.keySet()) {
            WordCount count = new WordCount(word, wordMap.get(word));
            counts.add(count);
            pw.println(count);
        }
        pw.close();

        System.out.println("Selection sort");
        long start = System.nanoTime();
        List<WordCount> sorted = selectionSort(counts);
        long end = System.nanoTime();
        System.out.println("Start time is " + start + " and end time is " + end);
        System.out.printf("Elapsed time is %f\n", (end - start) / 1e9);
        System.out.println();

        WordCount[] arr = counts.toArray(new WordCount[0]);
        System.out.println("Merge sort");
        start = System.nanoTime();
        Arrays.sort(arr);
        end = System.nanoTime();
        System.out.println("Start time is " + start + " and end time is " + end);
        System.out.printf("Elapsed time is %f\n", (end - start) / 1e9);
        System.out.println();

        scanner = new Scanner(System.in);
        System.out.print("Enter a word to search: ");
        String word = scanner.next();
        scanner.close();
        System.out.println();

        System.out.println("Binary search");
        start = System.nanoTime();
        int count = binarySearch(sorted, word);
        end = System.nanoTime();
        System.out.println("Start time is " + start + " and end time is " + end);
        System.out.printf("Elapsed time is %f\n", (end - start) / 1e9);
        if (count > 0) {
            System.out.println("Word found and occurred " + count + " times");
        } else {
            System.out.println("Word not in book");
        }
        System.out.println();

        System.out.println("Sequential search");
        start = System.nanoTime();
        count = sequentialSearch(counts, word);
        end = System.nanoTime();
        System.out.println("Start time is " + start + " and end time is " + end);
        System.out.printf("Elapsed time is %f\n", (end - start) / 1e9);
        if (count > 0) {
            System.out.println("Word found and occurred " + count + " times");
        } else {
            System.out.println("Word not in book");
        }
    }

    private static List<WordCount> selectionSort(List<WordCount> counts) {
        List<WordCount> unsorted = new ArrayList<WordCount>(counts);
        int length = unsorted.size();
        List<WordCount> sorted = new ArrayList<WordCount>();
        for (int i = 0; i < length; i++) {
            WordCount min = unsorted.get(0);
            int minIndex = 0;
            for (int j = 0; j < unsorted.size(); j++) {
                WordCount curr = unsorted.get(j);
                if (curr.compareTo(min) < 0) {
                    min = curr;
                    minIndex = j;
                }
            }
            sorted.add(min);
            unsorted.remove(minIndex);
        }
        return sorted;
    };

    private static int binarySearch(List<WordCount> counts, String word) {
        int left = 0;
        int right = counts.size() - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            int res = word.compareTo(counts.get(mid).getWord());
            if (res < 0) {
                right = mid - 1;
            } else if (res > 0) {
                left = mid + 1;
            } else {
                return counts.get(mid).getCount();
            }
        }
        return 0;
    };

    private static int sequentialSearch(List<WordCount> counts, String word) {
        for (WordCount count : counts) {
            if (count.getWord().equals(word)) {
                return count.getCount();
            }
        }
        return 0;
    };
}

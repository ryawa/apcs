public class WordCount implements Comparable<WordCount> {
    private final String word;
    private final int count;

    public WordCount(String word, int count) {
        this.word = word;
        this.count = count;
    }

    public String getWord() {
        return word;
    }

    public int getCount() {
        return count;
    }

    public String toString() {
        return word + ": " + count + " occurences";
    }

    public int compareTo(WordCount other) {
        return word.compareTo(other.word);
    }
}

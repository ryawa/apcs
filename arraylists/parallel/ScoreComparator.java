import java.util.Comparator;

public class ScoreComparator implements Comparator<Score> {
    public int compareTo(Score o1, Score o2) {
        return o1.getScore() - o2.getScore();
    }
}

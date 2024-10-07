public class Parallel {
    public static void main(String[] args) {
        Score[] scores = {
            new Score("John", 99),
            new Score("David", 87),
            new Score("Arthur", 95)
        }
        for (int i = 0; i < scores.length; i++) {
            System.out.println(scores[i].getName() + " " + scores[i].getScore());
        }
    }
}

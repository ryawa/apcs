import java.io.*;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) throws IOException {
    File weightsFile = new File("./weights.txt");
    
    Scanner scanCount = new Scanner(weightsFile);
    String line = scanCount.nextLine();
    scanCount.close();
    int count = 0;
    for (int i = 0; i < line.length(); i++) {
      if (Character.isWhitespace(line.charAt(i))) {
        count++;
      }
    }
    count++;
    
    int[][] weights = new int[count][count];
    Scanner scanWeights = new Scanner(weightsFile);
    for (int i = 0; i < count; i++) {
      for (int j = 0; j < count; j++) {
        weights[i][j] = scanWeights.nextInt();
        System.out.print(weights[i][j] + " ");
      }
      System.out.println();
    }
    scanWeights.close();
    
    String algo = "";
    TSPSolver solver;
    Scanner input = new Scanner(System.in);
    while (true) {
      System.out.print("Which algorithm? (brute force/nearest neighbor/cheapest link) ");
      algo = input.nextLine();
      if (algo.equals("brute force")) {
        solver = new BruteForce(weights);
        break;
      } else if (algo.equals("nearest neighbor")) {
        solver = new NearestNeighbor(weights);
        break;
      } else if (algo.equals("cheapest link")) {
        solver = new CheapestLink(weights);
        break;
      }
    }
    int start = -1;
    while (start < 0 || start > count - 1) {
      System.out.print("Where to start? ");
      start = input.nextInt();
    }
    Path shortestPath = solver.findShortestPath(new Path(start));
    System.out.println(shortestPath);
    input.close();
  }
}
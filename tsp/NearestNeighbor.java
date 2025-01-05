import java.util.Arrays;

public class NearestNeighbor implements TSPSolver {
  private int[][] weights;
  private int[][] sortedIndices;

  public NearestNeighbor(int[][] weights) {
    this.weights = weights;
    this.sortedIndices = getSortedIndices();
    for (int i = 0; i < sortedIndices.length; i++) {
      for (int j = 0; j < sortedIndices[i].length; j++) {
        System.out.print(sortedIndices[i][j]);
      }
      System.out.println();
    }
  }

  public Path findShortestPath(Path visited) {
    System.out.println(visited);
    if (visited.size() == weights.length) {
      return visited.copy();
    }
    int last = visited.getLast();
    for (int i = 0; i < sortedIndices[last].length; i++) {
      int next = sortedIndices[last][i];
      if (!visited.contains(next) && weights[last][next] != -1) {
        visited.push(next, weights[last][next]);
        Path answer = findShortestPath(visited);
        visited.pop();
        if (answer == null) {
          System.out.println("Got null");
        }
        if (answer != null) {
          return answer;
        }
      }
    }
    System.out.println("Didn't find any options");
    return null;
  }

  // public Path findShortestPath(Path start) {
  //   Path visited = start.copy();
  //   boolean[][] impossible = new boolean[weights.length][weights[0].length];
  //   while (true) {
  //     System.out.println(visited);
  //     int last = visited.getLast();
  //     boolean found = false;
  //     for (int i = 0; i < sortedIndices[last].length; i++) {
  //       int next = sortedIndices[last][i];
  //       if (!visited.contains(next) && weights[last][next] != -1 && !impossible[last][next]) {
  //         found = true;
  //         visited.push(next, weights[last][next]);
  //         break;
  //       }
  //     }
  //     if (!found) {
  //       int removed = visited.pop();
  //       System.out.println("impossible from " + visited.getLast() + " to " + removed);
  //       // maybe needs recursion because impossible only based on previous visited
  //       impossible[visited.getLast()][removed] = true;
  //     }
  //     if (visited.size() == weights.length) {
  //       visited.push(visited.getFirst(), weights[visited.getLast()][visited.getFirst()]);
  //       break;
  //     }
  //   }
  //   return visited;
  // }

  private int[][] getSortedIndices() {
    int[][] sortedWeights = new int[weights.length][weights[0].length];
    int[][] sortedIndices = new int[weights.length][weights[0].length];
    for (int i = 0; i < sortedWeights.length; i++) {
      sortedWeights[i] = Arrays.copyOf(weights[i], weights[i].length);
      Arrays.sort(sortedWeights[i]);
      for (int j = 0; j < sortedWeights[i].length; j++) {
        sortedIndices[i][j] = find(weights[i], sortedWeights[i][j]);
      }
    }
    return sortedIndices;
  }

  private int find(int[] haystack, int needle) {
    int index = -1;
    for (int i = 0; i < haystack.length; i++) {
      if (haystack[i] == needle) {
        index = i;
      }
    }
    return index;
  }
}
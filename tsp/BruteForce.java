public class BruteForce implements TSPSolver {
  private int[][] weights;

  public BruteForce(int[][] weights) {
    this.weights = weights;
  }

  public Path findShortestPath(Path visited) {
    if (visited.size() == weights.length) {
      int distance = weights[visited.getLast()][visited.getFirst()];
      if (distance == -1) {
        return null;
      }
      visited.push(visited.getFirst(), distance);
      Path path = visited.copy();
      visited.pop();
      return path;
    }
    Path shortestPath = null;
    for (int i = 0; i < weights.length; i++) {
      if (visited.contains(i)) {
        continue;
      }
      int distance = weights[visited.getLast()][i];
      if (distance == -1) {
        continue;
      }
      visited.push(i, distance);
      Path path = findShortestPath(visited);
      if (path != null && (shortestPath == null || path.getLength() < shortestPath.getLength())) {
        shortestPath = path;
      }
      visited.pop();
    }
    return shortestPath;
  }
}

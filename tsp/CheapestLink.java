import java.util.ArrayList;
import java.util.Collections;

public class CheapestLink implements TSPSolver {
  private int[][] weights;
  ArrayList<Edge> sortedEdges;

  public CheapestLink(int[][] weights) {
    this.weights = weights;
    this.sortedEdges = sortEdges();
  }

  public Path findShortestPath(Path start) {
    boolean[][] graph = new boolean[weights.length][weights[0].length];
    int edgeCount = 0;
    int[] visitCounts = new int[weights.length];
    for (Edge e : this.sortedEdges) {
      if (edgeCount == weights.length) {
        break;
      }

      graph[e.getStart()][e.getEnd()] = true;
      graph[e.getEnd()][e.getStart()] = true;
      visitCounts[e.getStart()]++;
      visitCounts[e.getEnd()]++;

      if (hasCircuit(graph, new ArrayList<Integer>(), e.getStart()) || visitCounts[e.getStart()] >= 3
          || visitCounts[e.getEnd()] >= 3) {
        graph[e.getStart()][e.getEnd()] = false;
        graph[e.getEnd()][e.getStart()] = false;
        visitCounts[e.getStart()]--;
        visitCounts[e.getEnd()]--;
        continue;
      }
      edgeCount++;
    }
    return pathFromAdjacencyMatrix(graph, start.getFirst());
  }

  private ArrayList<Edge> sortEdges() {
    ArrayList<Edge> edgeList = new ArrayList<Edge>();
    for (int i = 0; i < weights.length; i++) {
      for (int j = 0; j < weights[i].length; j++) {
        if (i >= j) {
          continue;
        }
        edgeList.add(new Edge(i, j, weights[i][j]));
      }
    }
    Collections.sort(edgeList);
    return edgeList;
  }

  private boolean hasCircuit(boolean[][] graph, ArrayList<Integer> visited, int curr) {
    int last = -1;
    if (visited.size() > 0) {
      last = visited.get(visited.size() - 1);
    }
    for (int i = 0; i < graph[curr].length; i++) {
      if (i == curr || i == last) {
        continue;
      }
      if (graph[curr][i]) {
        if (visited.contains(i)) {
          return visited.size() < weights.length;
        }
        visited.add(curr);
        if (hasCircuit(graph, visited, i)) {
          return true;
        }
        visited.remove(visited.size() - 1);
      }
    }
    return false;
  }

  private Path pathFromAdjacencyMatrix(boolean[][] graph, int start) {
    Path path = new Path(start);
    for (int i = 0; i < weights.length; i++) {
      for (int j = 0; j < graph[path.getLast()].length; j++) {
        if (!path.contains(j)) {
          path.push(j, weights[path.getLast()][j]);
          break;
        }
      }
    }
    path.push(start, weights[path.getLast()][start]);
    return path;
  }
}

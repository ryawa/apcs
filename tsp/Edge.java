public class Edge implements Comparable<Edge> {
  private int start;
  private int end;
  private int weight;

  public Edge(int start, int end, int weight) {
    this.start = start;
    this.end = end;
    this.weight = weight;
  }

  public int getStart() {
    return start;
  }

  public int getEnd() {
    return end;
  }

  public int getWeight() {
    return weight;
  }

  public int compareTo(Edge other) {
    return weight - other.weight;
  }
}

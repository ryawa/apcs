import java.util.ArrayList;

public class Path {
  private ArrayList<Integer> locations = new ArrayList<Integer>();
  private ArrayList<Integer> distances = new ArrayList<Integer>();
  private int length = 0;

  public Path(int start) {
    locations.add(start);
  }

  public Path copy() {
    Path other = new Path(locations.get(0));
    for (int i = 1; i < locations.size(); i++) {
      other.push(locations.get(i), distances.get(i - 1));
    }
    return other;
  }

  public boolean contains(int location) {
    return locations.contains(location);
  }
  
  public int getFirst() {
    return locations.get(0);
  }

  public int getLast() {
    return locations.get(locations.size() - 1);
  }
  
  public int size() {
    return locations.size();
  }

  public int getLength() {
    return length;
  }

  public void push(int location, int distance) {
    locations.add(location);
    distances.add(distance);
    length += distance;
  }

  public int pop() {
    int element = locations.remove(locations.size() - 1);
    int distance = distances.remove(distances.size() - 1);
    length -= distance;
    return element;
  }

  public String toString() {
    String result = "";
    result += locations.get(0);
    for (int i = 1; i < locations.size(); i++) {
      result += "-" + locations.get(i);
    }
    result += " (length " + getLength() + ")";
    return result;
  }
}

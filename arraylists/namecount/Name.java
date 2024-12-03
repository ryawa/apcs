public class Name {
  private String name;
  private int count;

  public Name(String name, int count) {
    this.name = name;
    this.count = count;
  }

  public String getName() {
    return name;
  }

  public int getCount() {
    return count;
  }

  public void setCount(int count) {
    this.count = count;
  }

  public String toString() {
    return name + ": " + count + " times";
  }
}

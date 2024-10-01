import java.util.*;
import java.io.*;

public class NameCount {
  public static void main(String[] args) throws FileNotFoundException {
    ArrayList<Name> nameCounts = new ArrayList<Name>();
    Scanner s = new Scanner(new File("heart.txt"));
    s.useDelimiter("[^a-zA-Z]");
    while (s.hasNext()) {
      String name = s.next();
      if (name.length() == 0) {
        continue;
      }
      name = name.toLowerCase();
      boolean found = false;
      for (int i = 0; i < nameCounts.size(); i++) {
        Name nameCount = nameCounts.get(i);
        if (nameCount.getName().equals(name)) {
          nameCount.setCount(nameCount.getCount() + 1);
          found = true;
        }
      }
      if (!found) {
        nameCounts.add(new Name(name, 1));
      }
    }
    for (Name nameCount : nameCounts) {
      System.out.println(nameCount);
    }
    s.close();
    s = new Scanner(System.in);
    System.out.print("Enter a name to search: ");
    String name = s.next();
    boolean found = false;
    for (int i = 0; i < nameCounts.size(); i++) {
      Name nameCount = nameCounts.get(i);
      if (nameCount.getName().equals(name)) {
        System.out.println(nameCount);
        found = true;
      }
    }
    if (!found) {
      System.out.println("Not found");
    }
  }
}

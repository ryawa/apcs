// Simulates ARRAYLIST, have students implement this
// to better understand how the java api works

import java.util.Arrays;

public class MyArrayList {
    private Object[] list;
    private int numElements; // number of students currently in the list

    // Constructs the list, initially empty,
    // but can hold up to 100
    public MyArrayList(int length) {
        list = new Object[length];
        numElements = 0;
    }

    // Adds t to the end of the list
    public void add(Object t) {
        if (numElements >= list.length) {
            list = Arrays.copyOf(list, list.length * 2);
        }
        list[numElements++] = t;
    }

    // Returns the number of active elements on the list
    public int size() {
        return numElements;
    }

    // Returns the student in the i'th location (counting from 0)
    // Precondition: 0 <= i < size()
    public Object get(int i) {
        if (i < 0 || i >= numElements) {
            throw new IndexOutOfBoundsException();
        }
        return list[i];
    }

    // Sets the i'th location in the list to t;
    // returns the previous i'th element.
    public Object set(int i, Object t) {
        if (i < 0 || i >= numElements) {
            throw new IndexOutOfBoundsException();
        }
        Object old = list[i];
        list[i] = t;
        return old;
    }

    // Removes the i'th element, sliding all items beyond i up by one spot.
    // Returns the element removed
    public Object remove(int i) {
        if (i < 0 || i >= numElements) {
            throw new IndexOutOfBoundsException();
        }
        Object old = list[i];
        int j;
        for (j = i; j < numElements - 1; j++) {
            list[j] = list[j + 1];
        }
        list[j] = null;
        numElements--;
        return old;
    }
}

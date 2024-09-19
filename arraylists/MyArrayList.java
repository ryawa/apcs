public class MyArrayList {
    private Object[] arr;
    private int length;
    private int size;

    MyArrayList() {
        length = 10;
        arr = new Object[length];
    }

    public int getLength() {
        return length;
    }

    public int getSize() {
        return size;
    }

    public void add(Object o) {
        resize();
        arr[size++] = o;
    }

    public void addToBeginning(Object o) {
        resize();
        size++;

        for (int i = size - 1; i > 0; i--) {
            arr[i] = arr[i - 1];
        }
        arr[0] = o;
    }

    private void resize() {
        if (size < length) {
            return;
        }
        length *= 2;
        Object newArr[] = new Object[length];
        for (int i = 0; i < size; i++) {
            newArr[i] = arr[i];
        }
        arr = newArr;
    }

    public int find(Object o) {
        for (int i = 0; i < size; i++) {
            if (arr[i] == o) {
                return i;
            }
        }
        return -1;
    }

    public Object get(int i) {
        return arr[i];
    }

    public boolean remove(Object o) {
        int loc = find(o);
        if (loc == -1) {
            return false;
        }
        for (int i = loc; i < size - 1; i++) {
            arr[i] = arr[i + 1];
        }
        arr[size - 1] = null;
        size--;
        return true;
    }

    public String toString() {
        String s = "{";
        for (int i = 0; i < size - 1; i++) {
            s += arr[i].toString();
            s += ", ";
        }
        s += arr[size - 1].toString();
        s += "}";
        return s;
    }
}

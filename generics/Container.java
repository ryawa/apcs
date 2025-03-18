import java.util.Iterator;

public class Container<T> implements Iterable<T> {
    private T[] data;
    private int size = 0;
    private int capacity = 10;

    public Container() {
        data = (T[]) new Object[capacity];
    }

    public void resize() {
        capacity *= 2;
        T[] ndata = (T[]) new Object[capacity];
        for (int i = 0; i < capacity / 2; i++) {
            ndata[i] = data[i];
        }
        ndata = data;
    }

    public void add(T el) {
        if (size >= capacity) {
            resize();
        }
        data[size++] = el;
    }

    public void remove(int idx) {
        for (int i = idx; i < size - 1; i++) {
            data[i] = data[i + 1];
        }
        size--;
    }

    public T get(int idx) {
        return data[idx];
    }

    public int size() {
        return size;
    }

    public Iterator<T> iterator() {
        return new ContainerIterator();
    }

    private class ContainerIterator implements Iterator<T> {
        private int i = 0;

        public boolean hasNext() {
            return i < size();
        }

        public T next() {
            return get(i++);
        }
    }
}

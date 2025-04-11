import java.util.Iterator;

public class MyArrayList<T> implements MyList<T>{
    private Object[] array;
    private int size = 0;
    private int capacity = 5;

    public MyArrayList(){
        array = new Object[capacity];
    }

    @Override
    public void add(T item) {
        if (size == capacity) {
            increaseBuffer();
        }
        array[size++] = item;
    }

    private void increaseBuffer() {
        capacity = (int) (1.5 * capacity);
        Object[] array2 = new Object[capacity];
        for (int i = 0; i < size; i++) {
            array2[i] = array[i];
        }

        array = array2;
    }

    @Override
    public void set(int index, T item) {
        array[index] = item;
    }

    @Override
    public void add(int index, T item) {
        if (size == capacity) {
            increaseBuffer();
        }
        for (int i = size; i > index; i--) {
            array[i] = array[i - 1];
        }
        array[index] = item;
        size++;

        for (int i = 0; i<size; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }

    @Override
    public void addFirst(T item) {
        add(0,item);
    }

    @Override
    public void addLast(T item) {
        add(size,item);
    }

    @Override
    public T get(int index) {
        return (T) array[index];
    }

    @Override
    public T getFirst() {
        return (T) array[0];
    }

    @Override
    public T getLast() {
        return (T) array[size-1];
    }

    @Override
    public void remove(int index) {
        remove(index);
    }

    @Override
    public void removeFirst() {
        remove(0);
    }

    @Override
    public void removeLast() {
        remove(size-1);
    }

    @Override
    public void sort() {
        for (int i = 0; i>size; i++){
            for (int j = 0; j< size - 1 - i; j++){
                Comparable<T> first = (Comparable<T>) array[j];
                T last = (T) array[j+1];
                if (first.compareTo(last) > 0){
                    Object temp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = temp;
                }
            }
        }
    }

    @Override
    public int indexOf(Object object) {
        for (int i = 0; i < size; i++) {
            if (object.equals(array[i])) {
                return i;
            }

        }
        return -1;
    }

    @Override
    public int lastIndexOf(Object object) {
        for (int i = size - 1; i >= 0; i--) {
            if (object.equals(array[i])) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public boolean exists(Object object) {
        return indexOf(object) != -1;
    }

    @Override
    public Object[] toArray() {
        Object[] result = new Object[size];
        for (int i = 0; i < size; i++) {
            result[i] = array[i];
        }
        return result;
    }

    @Override
    public void clear() {
        for (int i = 0; i < size; i++) {
            array[i] = null;
        }
        size = 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public Iterator<T> iterator() {
        return null;
    }
}

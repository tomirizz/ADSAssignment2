import java.util.Iterator;

public class MyLinkedList<T> implements MyList<T> {
    private MyNode<T> head;
    private MyNode<T> tail;
    private int size;

    @Override
    public Iterator<T> iterator() {
        return new MyIterator();
    }

    @Override
    public void add(T item) {
        MyNode<T> newNode = new MyNode<>(item);
        if (head == null) {
            head = newNode;
        }
        else{
            MyNode<T> current = head;
            while (current.next != null)
                current = current.next;
            current.next = newNode;
        }
        size++;
    }

    @Override
    public void set(int index, T item) {
        MyNode<T> current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        current.data = item;
    }

    @Override
    public void add(int index, T item) {
        MyNode<T> current = head;
        for (int i = 0; i < index - 1; i++) {
            current = current.next;
        }
        MyNode<T> previous = current;
        MyNode<T> newNode = new MyNode<>(item);
        newNode.next = previous.next;
        previous.next = newNode;
        size++;
    }

    @Override
    public void addFirst(T item) {
        MyNode<T> newNode = new MyNode<>(item);
        newNode.next = head;
        head = newNode;
        if (tail == null) tail = head;
        size++;
    }

    @Override
    public void addLast(T item) {
        if (head == null) {
            add(item);
            return;
        }
        MyNode<T> newNode = new MyNode<>(item);
        newNode.next = head;
        head = newNode;
        size++;
    }

    @Override
    public T get(int index) {
        MyNode<T> current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current.data;
    }

    @Override
    public T getFirst() {
        return head.data;
    }

    @Override
    public T getLast() {
        return tail.data;
    }

    @Override
    public void remove(int index) {
        MyNode<T> current = head;
        for (int i = 0; i < index - 1; i++) {
            current = current.next;
        }
        MyNode<T> previous = current;
        previous.next = previous.next.next;
        if (previous.next==null) tail = previous;
        size--;
    }

    @Override
    public void removeFirst() {
        if (head == tail){
            head = tail = null;
        }
        else{
            head = head.next;
        }
        size--;
    }

    @Override
    public void removeLast() {
        if (head == tail){
            head = tail = null;
        }
        else{
            MyNode<T> current = head;
            while (current.next != tail){
                current = current.next;
            }
            tail = current;
            tail.next = null;
        }
        size--;
    }

    @Override
    public void sort() {

    }

    @Override
    public int indexOf(Object object) {
        int index = 0;
        for (MyNode<T> current = head; current != null; current = current.next, index++){
            if (object.equals(current.data)) return index;

        }
        return -1;
    }

    @Override
    public int lastIndexOf(Object object) {
        int index = -1;
        int currentIndex = 0;
        for (MyNode<T> current = head; current != null; current = current.next, currentIndex++){
            if (object.equals(current.data)) index = currentIndex;
        }
        return index;
    }

    @Override
    public boolean exists(Object object) {
        return indexOf(object) != -1;
    }

    @Override
    public Object[] toArray() {
        Object[] result = new Object[size];
        int i = 0;
        for (MyNode<T> current = head; current != null; current = current.next){
            result[i++] = current.data;
        }
        return result;
    }

    @Override
    public void clear() {
        head = tail = null;
        size = 0;
    }

    @Override
    public int size() {
        return size;
    }

    private class MyIterator implements Iterator<T> {
        MyNode<T> cursor = head;

        @Override
        public boolean hasNext() {
            return cursor != null;
        }

        @Override
        public T next() {
            T nextItem = cursor.data;
            cursor = cursor.next;
            return nextItem;
        }
    }

    private static class MyNode<E> {
        E data;
        MyNode<E> next;

        MyNode(E data) {
            this.data = data;
        }
    }
}

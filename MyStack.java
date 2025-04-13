public class MyStack<T> {
    private MyArrayList<T> arrayList = new MyArrayList<>();

    public boolean arrayEmpty() {
        return arrayList.size() == 0;
    }

    public int arraySize() {
        return arrayList.size();
    }

    public T arrayPush(T newItem) {
        arrayList.addLast(newItem);
        return newItem;
    }

    public T arrayPeek() {
        return arrayList.getLast();
    }

    public T arrayPop() {
        T removingItem = arrayPeek();
        arrayList.removeLast();
        return removingItem;
    }

    private MyLinkedList<T> linkedList = new MyLinkedList<>();

    public boolean listEmpty() {
        return linkedList.size() == 0;
    }

    public int listSize() {
        return linkedList.size();
    }

    public T listPush(T newItem) {
        linkedList.addLast(newItem);
        return newItem;
    }

    public T listPeek() {
        return linkedList.getLast();
    }

    public T listPop() {
        T removingItem = linkedList.getLast();
        linkedList.removeLast();
        return removingItem;
    }
}

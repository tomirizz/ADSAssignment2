public class MyQueue<T> {
    private MyLinkedList<T> list = new MyLinkedList<>();

    public boolean empty(){
        return list.size() == 0;
    }

    public int size(){
        return list.size();
    }

    public T peek(){
        return list.get(0);
    }

    public T enqueue(T newItem){
        list.add(newItem);
        return newItem;
    }

    public T dequeue(){
        T removingItem = peek();
        list.removeFirst();
        return removingItem;
    }
}

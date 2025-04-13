public class MyHeap<T extends Comparable<T>> {
    private MyArrayList<T> heap = new MyArrayList<>();

    public boolean empty(){
        return heap.size() == 0;
    }

    public int size(){
        return heap.size();
    }

    public void insert(T newItem){
        heap.add(newItem);
        heapify(heap.size() - 1);
    }

    public T getMax(){
        return heap.get(heap.size()-1);
    }

    public T getMin(){
        return heap.get(0);
    }

    public T extractMin(){
        if (heap.size()==0) return null;
        T minimum = heap.get(0);
        heap.set(0, heap.get(heap.size()-1));
        heap.removeLast();
        heapify(0);
        return minimum;
    }

    private void heapify(int index){
        int left = index*2+1;
        int right = index*2+2;
        int minimum = index;
        if (left < heap.size() && heap.get(left).compareTo(heap.get(minimum)) < 0){
            minimum = left;
        }
        else if (right < heap.size() && heap.get(right).compareTo(heap.get(minimum)) < 0){
            minimum = right;
        }
        if (minimum != index){
            T temp = heap.get(index);
            heap.set(index, heap.get(minimum));
            heap.set(minimum, temp);
            heapify(minimum);
        }

    }



}

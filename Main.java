public class Main {
    public static void main(String[] args) {
        MyArrayList<Integer> arrayList = new MyArrayList<>();
        int n = 10;
        for (int i = 0; i < n; i++) {
            arrayList.add(i);
        }
        arrayList.set(7, 2);
        arrayList.add(2, 8);
        arrayList.addFirst(3);
        arrayList.addLast(5);
        System.out.println(arrayList.get(8));
        System.out.println(arrayList.getFirst());
        System.out.println(arrayList.getLast());
        arrayList.remove(1);
        arrayList.removeFirst();
        arrayList.removeLast();
        arrayList.sort();
        System.out.println(arrayList.indexOf(13));
        System.out.println(arrayList.lastIndexOf(2));
        System.out.println(arrayList.exists(19));
        System.out.println(arrayList.toArray());
        arrayList.clear();
        System.out.println(arrayList.size());


        MyLinkedList<Integer> linkedList = new MyLinkedList<>();
        for (int i = 0; i < n; i++) {
            linkedList.add(i);
        }
        for (int i = 0; i < n; i++) {
            System.out.println(linkedList.get(i));
        }
        linkedList.set(2,19);
        linkedList.add(4,7);
        linkedList.addFirst(8);
        linkedList.addLast(99);
        System.out.println(linkedList.get(2));
        System.out.println(linkedList.getFirst());
        System.out.println(linkedList.getLast());
        linkedList.remove(2);
        linkedList.removeFirst();
        linkedList.removeLast();
        System.out.println(linkedList.indexOf(4));
        System.out.println(linkedList.lastIndexOf(5));
        System.out.println(linkedList.exists(99));
        linkedList.toArray();
        linkedList.clear();
        linkedList.size();
    }
}

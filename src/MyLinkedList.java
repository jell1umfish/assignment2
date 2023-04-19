public class MyLinkedList<E> implements MyList<E> {

    private class Node {
        private E element;
        private Node next;
        private Node prev;

        public Node(E element, Node next, Node prev) {
            this.element = element;
            this.next = next;
            this.prev = prev;
        }
    }

    private Node head;
    private Node tail;
    private int size;

    public MyLinkedList() {
        head = null;
        tail = null;
        size = 0;
    }
    public void add(E element) {
        Node newNode = new Node(element, null, tail);
        if (isEmpty()) {
            head = newNode;
        } else {
            tail.next = newNode;
        }
        tail = newNode;
        size++;
    }


    private boolean isEmpty() {
        return size == 0;
    }
}

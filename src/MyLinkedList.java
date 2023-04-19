public class MyLinkedList<T> implements MyList<T>{
    private class Node {
        private Object element;
        private Node next;
        private Node prev;

        public Node(Object element, Node next, Node prev) {
            this.element = element;
            this.next = next;
            this.prev = prev;
        }

}

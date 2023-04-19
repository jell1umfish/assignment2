public class MyLinkedList<T> implements MyList<T> {

    private class Node {
        private T element;
        private Node next;
        private Node prev;

        public Node(T element, Node next, Node prev) {
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
    public void add(T element) {
        Node newNode = new Node(element, null, tail);
        if (isEmpty()) {
            head = newNode;
        } else {
            tail.next = newNode;
        }
        tail = newNode;
        size++;
    }
    public T get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        Node currentNode;
        if (index < size / 2) {
            currentNode = head;
            for (int i = 0; i < index; i++) {
                currentNode = currentNode.next;
            }
        } else {
            currentNode = tail;
            for (int i = size - 1; i > index; i--) {
                currentNode = currentNode.prev;
            }
        }

        return currentNode.element;
    }
    public T remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }

        Node nodeToRemove;
        if (index == 0) {
            nodeToRemove = head;
            head = nodeToRemove.next;
        } else if (index == size - 1) {
            nodeToRemove = tail;
            tail = nodeToRemove.prev;
        } else {
            Node currentNode;
            if (index < size / 2) {
                currentNode = head;
                for (int i = 0; i < index; i++) {
                    currentNode = currentNode.next;
                }
            } else {
                currentNode = tail;
                for (int i = size - 1; i > index; i--) {
                    currentNode = currentNode.prev;
                }
            }
            nodeToRemove = currentNode;
            currentNode.prev.next = currentNode.next;
            currentNode.next.prev = currentNode.prev;
        }

        size--;
        return nodeToRemove.element;
    }
    public boolean remove(T item) {
        Node current = head;
        while (current != null) {
            if (current.element.equals(item)) {
                if (current == head) {
                    // removing the first element
                    head = current.next;
                    if (head != null) {
                        head.prev = null;
                    } else {
                        tail = null;
                    }
                } else if (current == tail) {
                    // removing the last element
                    tail = current.prev;
                    if (tail != null) {
                        tail.next = null;
                    } else {
                        head = null;
                    }
                } else {
                    // removing an element in the middle
                    current.prev.next = current.next;
                    current.next.prev = current.prev;
                }
                size--;
                return true;
            }
            current = current.next;
        }
        return false;
    }
    public int size(){
        return size;
    }

    public boolean contains(Object o) {
        Node currentNode = head;
        while (currentNode != null) {
            if (currentNode==o) {
                return true;
            }
            currentNode = currentNode.next;
        }
        return false;
    }
    public void add(T item, int index) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }

        Node newNode = new Node(item, null, null);
        if (size == 0) {
            head = tail = newNode;
        } else if (index == 0) {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        } else if (index == size) {
            newNode.prev = tail;
            tail.next = newNode;
            tail = newNode;
        } else {
            Node currentNode = head;
            for (int i = 0; i < index; i++) {
                currentNode = currentNode.next;
            }
            newNode.next = currentNode;
            newNode.prev = currentNode.prev;
            currentNode.prev.next = newNode;
            currentNode.prev = newNode;
        }

        size++;
    }
    public void sort(){
        if (head == null || head.next == null) {
            System.out.println("i didnt get it");
        }
    }
    public void clear() {
        head = null;
        tail = null;
        size = 0;
    }

    public int indexOf(Object o) {
        int index = 0;
        Node current = head;
        while (current != null) {
            if (current.element.equals(o)) {
                return index;
            }
            current = current.next;
            index++;
        }
        return -1;
    }
    public int lastIndexOf(Object o) {
        int index = size - 1;
        Node current = tail;
        while (current != null) {
            if (current.element.equals(o)) {
                return index;
            }
            current = current.prev;
            index--;
        }
        return -1;
    }

    private boolean isEmpty() {
        return size == 0;
    }
}

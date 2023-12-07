public class GenericLinkedList<T> {
    private class Node<T> {
        T value;
        Node next;

        Node(T value) {
            this.value = value;
        }

    }

    private Node head;
    private Node tail;
    private int size = 0;

    public void addFirst(T value) {// O(1)
        Node x = new Node(value);
        if (this.head == null) {
            head = tail = x;
        } else {
            x.next = head;
            head = x;
        }
        size++;

    }

    public void addLast(T value) {//O(1)
        Node x = new Node(value);
        if (this.head == null) {
            head = tail = x;
        } else {
            tail.next = x;
            tail = x;
        }
        size++;
    }

    public void removeFirst() { // O(1)
        if (head == null) {
            return;
        } else if (head.next == null) {
            head = tail = null;
        } else {
            Node tmp = head.next;
            head.next = null;
            head = tmp;
        }
        size--;
    }

    public void removeLast() {//O(n)
        if (head == null) {
            return;
        } else if (head.next == null) {
            head = tail = null;
        } else {
            Node current = head.next;
            Node previous = head;
            while (current.next != null) {
                previous = current;
                current = current.next;
            }
            previous.next = null;
            tail = previous;
        }
        size--;
    }

    public int indexOf(T value) {//O(n)
        Node current = head;
        int count = 0;
        while (current != null) {
            if (current.value == value) {
                return count;
            }
            current = current.next;
            count++;
        }
        return -1;
    }

    public boolean contains(T value) {//O(n)
        return indexOf(value) != -1;
    }

    public int size() {//O(1) for this function but it takes O(n) to compute
        return size;
    }

    public void printElements() {//O(n)
        if (head == null) {
            throw new NullPointerException("Empty list");
        }
        Node current = head;

        while (current != null) {
            System.out.print(current.value + ",");
            current = current.next;
        }
        System.out.println();
    }

    public void reverse() {//O(n)
        if (head == null) {
            return;
        }
        Node current = head.next;
        Node previous = head;
        head.next = null;
        while (current != null) {
            Node tmp = current.next;
            current.next = previous;
            previous = current;
            current = tmp;
        }
        Node tmp = head;
        head = tail;
        tail = tmp;
    }


}

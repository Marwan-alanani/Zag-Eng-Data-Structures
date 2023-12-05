public class LinkedList {
    class Node {
        int value;
        Node next;

        Node(int value) {
            this.value = value;
        }

    }

    private Node head;
    private Node tail;
    private int size = 0;

    public void addFirst(int value) {// O(1)
        Node x = new Node(value);
        if (this.head == null) {
            head = tail = x;
        } else {
            x.next = head;
            head = x;
        }
        size++;

    }

    public void addLast(int value) {//O(1)
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
        if(head  == null)
        {
            return;
        }
        if (head.next == null) {
            head = tail = null;
        } else {
            Node tmp = head.next;
            head.next = null;
            head = tmp;
        }
        size--;
    }

    public void removeLast() {//O(n)
        if(head  == null)
        {
            return;
        }
        if (head.next == null) {
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

    public int indexOf(int value) {//O(n)
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

    public boolean contains(int value) {//O(n)
        return indexOf(value) != -1;
    }

    public int size() {//O(1) for this function but it takes O(n) to compute
        return size;
    }

    public void printElements() {//O(n)
        if(head ==null){
            throw new NullPointerException("Empty list");
        }
        Node current = head;

        while (current != null) {
            System.out.print(current.value + ",");
            current = current.next;
        }
        System.out.println();
    }

    public int max() {//O(n)
        Node current = head;
        if (current == null) {
            throw new NullPointerException();
        }
        int max = current.value;
        while (current != null) {
            if (current.value > max) {
                max = current.value;
            }
            current = current.next;
        }
        return max;
    }
    public int min() {//O(n)
        Node current = head;
        if (current == null) {
            throw new NullPointerException();
        }
        int min = current.value;
        while (current != null) {
            if (current.value < min) {
                min = current.value;
            }
            current = current.next;
        }
        return min;
    }

}

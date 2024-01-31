public class QueueLinkedList<T> {
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

    public <T> void enqueue(T value) { //O(1)
        Node x = new Node(value);
        if (isEmpty()) {
            head = tail = x;
        } else {
            tail.next = x;
            tail = x;
        }
        size++;

    }

    public T dequeue() { //O(1)
        if (isEmpty())
            throw new IllegalStateException("Queue is Empty");
        Node previousHead = head;
        head = head.next;
        previousHead.next = null;
        size--;
        return (T) previousHead.value;

    }

    public T peek() throws IllegalAccessException { //O(1)
        if (isEmpty())
            throw new IllegalAccessException("Queue is empty");
        return (T) head.value;
    }

    public boolean isEmpty() { //O(1)
        return size == 0;
    } //O(1)

    public int size() { //O(1)
        return size;
    } //O(1)

    public void print() { //O(n)
        System.out.print("[ ");
        if (!isEmpty()) {
            Node current = head;
            while (current != tail) {
                System.out.print(current.value + " , ");
                current = current.next;
            }
            System.out.print(tail.value + " ]");
        } else {
            System.out.print("]");
        }

    }

}

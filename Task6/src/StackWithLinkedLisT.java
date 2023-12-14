public class StackWithLinkedLisT<T> {
    private class Node<T> {
        T value;
        Node nextNode;

        Node(T value) {
            this.value = value;
        }
    }

    private Node head;



    public void push(T item) {
        Node tmp = new Node(item);
        tmp.nextNode = head;
        this.head = tmp;
    }

    public T peek() {
        if (head == null) {
            throw new IllegalStateException("Stack is empty");
        }
        return (T)head.value;
    }

    public T pop() {
        if (head == null) {
            throw new IllegalStateException("Stack is empty");
        }
        T value = (T)head.value;
        head = head.nextNode;
        return value;
    }
    public boolean isEmpty(){
        return head==null;
    }
}

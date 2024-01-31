import java.util.Stack;
import java.lang.Integer;

public class QueueStack {
    private Stack<Integer> st1 = new Stack<Integer>(); // Stack for enqueue
    private Stack<Integer> st2 = new Stack<Integer>(); // Stack for dequeue and peek
    private int size = 0;

    public boolean isEmpty() {
        return st1.isEmpty() && st2.isEmpty();
    } //O(1)

    public void enqueue(int value) { // O(1)
        st1.push(value);
        size++;
    }

    public int dequeue() { // O(n)
        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty");
        }
        if (st2.isEmpty()) {
            reorder();
        }
        size--;
        return st2.pop();
    }

    public int peek() throws IllegalAccessException { //O(n)
        if (isEmpty())
            throw new IllegalAccessException("Queue is empty");
        if (st2.isEmpty()) {
            reorder();
        }
        return st2.peek();
    }

    private void reorder() { //O(n)
        while (!st1.isEmpty()) {
            st2.push(st1.pop());
        }
    }

    public int size() { //O(1)
        return size;
    } //O(1)

    public void print() { //O(n)
        System.out.print("[ ");
        if (!isEmpty()) {
            Stack<Integer> tempStack = new Stack<Integer>();
            for (int i = 0; i < size - 1; i++) {
                if (st2.isEmpty()) {
                    reorder();
                }
                System.out.print(st2.peek() + " , ");
                tempStack.push(st2.pop());
            }
            System.out.print(st2.peek() + " ]");
            for (int i = 0; i < size - 1; i++) {
                st2.push(tempStack.pop());
            }

        } else {
            System.out.print("]");
        }

    }

}

import java.lang.reflect.Array;

public class QueueFixedArray<T> {
    private T[] array;
    private final int maxSize;
    private int head = 0;
    private int size = 0;
    private int current = 0;

    public QueueFixedArray(int size) {
        this.maxSize = size;
        this.array = (T[]) new Object[size];
    }

    public void enqueue(T value) { //O(1)
        if (isFull())
            throw new IllegalStateException("Queue is full");
        size++;
        array[current % maxSize] = value;
        current++;

    }

    public T dequeue() { //O(1)
        if (isEmpty())
            throw new IllegalStateException("Queue is empty");
        int previousHead = head;
        head++;
        size--;
        return array[previousHead % maxSize];
    }

    public boolean isFull() { //O(1)
        return size == maxSize;
    } //O(1)

    public boolean isEmpty() { //O(1)
        return size == 0;
    } //O(1)

    public T peek() throws IllegalAccessException { //O(1)
        if (isEmpty())
            throw new IllegalAccessException("No elements in queue");
        return array[head % maxSize];
    }

    public int size() { //O(1)
        return size;
    } //O(1)

    public void print() { //O(n)
        System.out.print("[ ");
        if (!isEmpty()) {
            for (int i = head; i < current - 1; i++) {
                System.out.print(array[i % maxSize] + " , ");
            }
            System.out.print(array[(current - 1) % maxSize] + " ]");
        } else {
            System.out.print("]");
        }

    }

}

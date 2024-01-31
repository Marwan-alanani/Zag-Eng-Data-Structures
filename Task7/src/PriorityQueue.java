

public class PriorityQueue {
    private int[] array;
    private int maxSize;
    private int size = 0;

    PriorityQueue(int size) {
        this.maxSize = size;
        array = new int[size];
    }

    public void enqueue(int value) throws IllegalStateException { //O(logn)
        if (isFull()) {
            throw new IllegalStateException("Queue is full");
        }
        array[size] = value;
        sortInsert(size);
        size++;
    }

    public int dequeue() { //O(logn)
        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty");
        }
        swap(0, size - 1);
        int oldSize = size;
        size--;
        int child1Index = 1;
        int child2Index = 2;
        sortDelete(child1Index, child2Index, 0);
        return array[oldSize - 1];
    }

    public int peek() throws IllegalStateException { //O(1)
        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty");
        }
        return array[0];
    }

    private void sortInsert(int index) { //O(logn)
        int parentIndex = (index - 1) / 2;
        //
        if (!(array[parentIndex] < array[index])) {
            return;
        }

        swap(parentIndex, index);
        sortInsert(parentIndex);
    }

    private void sortDelete(int child1, int child2, int currentIndex) { //O(logn)
//        compare with first child
        if (array[child1] > array[currentIndex] && child1 < size) {
            swap(child1, currentIndex);
            sortDelete(2 * child1 + 1, 2 * child1 + 2, child1);
//            compare with second child
        } else if (array[child2] > array[currentIndex] && child2 < size) {
            swap(child2, currentIndex);
            sortDelete(2 * child2 + 1, 2 * child2 + 2, child2);
        }
    }


    private void swap(int index1, int index2) { //O(1)
        int a = array[index1];
        array[index1] = array[index2];
        array[index2] = a;
    }

    public boolean isEmpty() { //O(1)
        return size == 0;
    }

    public boolean isFull() { //O(1)
        return size == maxSize;
    }

    public int size() { // O(1)
        return size;
    } //O(1)

    public void print() { //O(n)
        System.out.print("[ ");
        if (!isEmpty()) {
            for (int i = 0; i < size - 1; i++) {
                System.out.print(array[i] + ", ");
            }
            System.out.print(array[size-1] + " ]");
        } else {
            System.out.print("]");
        }

    }
}

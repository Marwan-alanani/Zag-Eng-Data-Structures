public class DynamicArray {
    private int count;
    private int[] items;



    DynamicArray(int N) {
        this.items = new int[N * 2];
    }

    DynamicArray() {
        this(50);
    }

    public void insert(int item) {
        if (count == items.length) {
            reconstruct(count);
        }
        items[count] = item;
        count++;
    }

    private void reconstruct(int count) {
        int[] newArray = new int[count * 2];
        for (int i = 0; i < count; i++) {
            newArray[i] = items[i];
        }
        items = newArray;
    }

    public void printArray() {
        for (int i = 0; i < count; i++) {
            System.out.print(items[i] + ",");
        }
        System.out.println();
    }

    public void removeAt(int index) {
        checkIndex(index);
        for (int i = index; i < count - 1; i++) {
            items[i + 1] = items[i];
        }
        count--;

    }

    public int at(int index) {
        checkIndex(index);
        return items[index];
    }

    private void checkIndex(int index) {
        if (index < 0 || index >= count) {
            throw new IllegalArgumentException("Invalid index");
        }
    }

    public int indexOf(int item) {
        for (int i = 0; i < count; i++) {
            if (items[i] == item)
                return i;
        }
        return -1;
    }

    public void remove(int item) {
        int index = indexOf(item);
        if (index == -1)
            return;
        removeAt(index);
    }

    public int max() {
        if (count == 0)
            throw new IllegalArgumentException("Invalid use of function");
        int max = items[0];
        for (int i = 1; i < count; i++) {
            if (items[i] > max)
                max = items[i];
        }
        return max;

    }
    public int min() {
        if (count == 0)
            throw new IllegalArgumentException("Invalid use of function");
        int min = items[0];
        for (int i = 1; i < count; i++) {
            if (items[i] < min)
                min = items[i];
        }
        return min;

    }

}

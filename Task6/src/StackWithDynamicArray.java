

import java.lang.reflect.Array;

public class StackWithDynamicArray<T> {
    private T[] array;
    private int availableSpace = 50;
    private int size = 0;
    private Class type;



    public StackWithDynamicArray(Class<T> type) {
        this.type = type;
        array = (T[]) Array.newInstance(type, availableSpace);
    }

    private void reinstantiate() {
        availableSpace = size * 2;
        T[] newArray = (T[]) Array.newInstance(type, availableSpace);
        for (int i = 0; i < size; i++) {
            newArray[i] = array[i];
        }
        array = newArray;
    }

    public void push(T item) {
        if (size == availableSpace) {
            reinstantiate();
        }
        array[size] = item;
        size++;
    }
    public T peek(){
        if(size == 0){
            throw new IllegalStateException("Stack is empty");
        }
        return array[size-1];
    }
    public T pop(){
        if(size == 0){
            throw new IllegalStateException("Can't pop out of empty stack");
        }
        size--;
        return array[size];
    }

}




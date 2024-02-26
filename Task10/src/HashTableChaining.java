import java.util.LinkedList;
import java.util.NoSuchElementException;

public class HashTableChaining {
    private class Node {
        private int key;
        private String value;

        Node(int key, String val) {
            this.key = key;
            this.value = val;
        }

    }

    private LinkedList<Node>[] table;
    private int size = 0;

    HashTableChaining(int size) {
        if (size > 0)
        {
            table = new LinkedList[size];
            return;
        }
        throw new IllegalArgumentException("Size can't be less than one");

    }
    HashTableChaining(){
        table = new LinkedList[20];
    }


    public void put(int key, String val) {
        Node node = new Node(key, val);
        int index = hash(key);

        if (table[index] == null)
            table[index] = new LinkedList<Node>();


        if (!table[index].isEmpty()) {
            int count = 0;
            //        if key is in hash Table only overwrite value
            for (Node e : table[index]) {
                if (e.key == key) {
                    table[index].set(count, node);
                    return;
                }
                count++;
            }
        }


        table[index].add(node);
        size++;
    }

    public String get(int key) {

        int index = hash(key);

        if (table[index] == null)
            throw new NoSuchElementException("No element with the given key");

        if (!table[index].isEmpty()) {
            for (Node node : table[index]) {
                if (node.key == key) {
                    return node.value;
                }
            }
        }


        throw new NoSuchElementException("No element with the given key");
    }

    public void remove(int key) {
        int index = hash(key);

        if (table[index] == null)
            return;

        if (!table[index].isEmpty()) {
            int count = 0;
            for (Node node : table[index]) {
                if (node.key == key) {
                    table[index].remove(count);
                    size--;
                }
                count++;
            }
        }

    }

    public int size() {
        return size;
    }

    private int hash(int key) {
        return key % table.length;
    }

}

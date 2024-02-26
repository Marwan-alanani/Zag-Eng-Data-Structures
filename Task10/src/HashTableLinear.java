import java.util.NoSuchElementException;

public class HashTableLinear {
    private class Node {
        private int key;
        private String value;

        Node(int key, String val) {
            this.key = key;
            this.value = val;
        }

    }

    private Node[] table;
    private int size = 0;

    HashTableLinear(int size) {
        if (size > 0) {
            table = new Node[size];
            return;
        }
        throw new IllegalArgumentException("Size can't be less than one");


    }

    HashTableLinear() {
//        default capacity is 50
        table = new Node[50];
    }


    public void put(int key, String val) {

        Node node = new Node(key, val);

        if (size == table.length) {
            resize();
        }
        int index = hash(key);

        while (table[index] != null) {
//            overwrite if key exists in hash table
            if (table[index].key == key) {
                table[index] = node;
                return;
            }
            index = hash1(index);
        }
        table[index] = node;
        size++;
    }

    public String get(int key) { //O(N)
        int index = hash(key);
        int count = 0;
        while (count != size) {
            if (table[index].key == key) {
                return table[index].value;
            }
            count++;
            index = hash1(index);
        }
        throw new NoSuchElementException("No element with the given key");
    }

    public void remove(int key) {
        int index = hash(key);
        int count = 0;
        while (count != size) {
            if (table[index].key == key) {
                table[index] = null;
                size--;
            }
            index = hash1(index);
            count++;
        }
    }

    public int size() {
        return size;
    }

    private void resize() {

        HashTableLinear table2 = (table.length > 1) ? new HashTableLinear((int) (table.length * 1.5)) : new HashTableLinear(10);
        for (Node node : table) {
            table2.put(node.key, node.value);
            node = null;
        }
        table = null;
        table = table2.table;
    }

    private int hash(int key) {
        return key % table.length;

    }

    private int hash1(int previousHash) {
        return (previousHash + 1) % table.length;
    }

}

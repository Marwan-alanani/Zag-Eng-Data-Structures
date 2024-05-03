public class AVL {


    private class Node {
        private int value;
        Node right;
        Node left;
        private int height;

        Node(int value) {
            this.value = value;
        }


    }

    private Node root;

    AVL() {
    }

    public void insert(int value) {
        root = insert(root, value);
    }

    private Node insert(Node node, int value) {
        if (node == null) {
            return new Node(value);
        } else if (value >= node.value) {
            node.right = insert(node.right, value);
        } else {
            node.left = insert(node.left, value);
        }
        setHeight(node);
        return balance(node);
    }
    private void setHeight(Node node){
        node.height = Math.max(height(node.left), height(node.right)) + 1;
    }
    private Node balance(Node node) {
        if (balanceFactor(node) > 1) {
            if (balanceFactor(node.left) < 0)
                node.left = rotateLeft(node.left);
            return rotateRight(node);
        } else if (balanceFactor(node) < -1) {
            if (balanceFactor(node.right) > 0)
                node.right = rotateRight(node.right);
            return rotateLeft(node);
        }
        return node;
    }

    private Node rotateLeft(Node x) {
        Node newRoot = x.right;
        x.right = newRoot.left;
        newRoot.left = x;
        setHeight(x);
        setHeight(newRoot);
        return newRoot;
    }

    private Node rotateRight(Node x) {
        Node newRoot = x.left;
        x.left = newRoot.right;
        newRoot.right = x;
        setHeight(x);
        setHeight(newRoot);
        return newRoot;
    }

    private int balanceFactor(Node node) {
        return (node == null) ? 0 : (height(node.left) - height(node.right));
    }

    public boolean find(int value) {
        if (root == null) {
            return false;
        }
        Node current = root;
        while (current != null) {
            if (current.value == value) {
                return true;
            }
            if (current.value <= value) {
                current = current.right;
            } else {
                current = current.left;
            }

        }
        return false;
    }

    public Integer max() {
        if (root == null) {
            throw new RuntimeException("No elements in tree");
        }
        Node current = root;
        int max = root.value;
        while (current != null) {
            max = current.value;
            current = current.right;
        }
        return max;
    }

    public Integer min() {
        if (root == null) {
            throw new RuntimeException("No elements in tree");
        }

        Node current = root;
        int min = root.value;
        while (current != null) {
            min = current.value;
            current = current.left;
        }
        return min;
    }


    private int height(Node x) {
        return x == null ? -1 : 1 + Math.max(height(x.right), height(x.left));

    }


}



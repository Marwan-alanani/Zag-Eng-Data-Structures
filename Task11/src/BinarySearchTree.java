public class BinarySearchTree {
    private class Node {
        Integer value;
        Node right;
        Node left;

        Node(int value) {
            this.value = value;
        }

        Node() {
        }
    }

    private Node root;

    BinarySearchTree() {
    }

    public void insert(int value) {
        Node x = new Node(value);
        if (root == null) {
            root = x;

        } else {
            Node parent = getParent(value);
            if (value >= parent.value) {
                parent.right = x;
            } else {
                parent.left = x;
            }
        }
    }

    private Node getParent(int value) {
        Node previous = root;
        Node current = root;
        while (current != null) {
            previous = current;
            if (current.value <= value) {
                current = previous.right;
            } else {
                current = previous.left;
            }

        }
        return previous;
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

    private void traversePreorder(Node x) {
        if (x == null) {
            return;
        }
        System.out.print(x.value + " ");
        traversePreorder(x.left);
        traversePreorder(x.right);

    }

    public void traversePreorder() {
        if (root == null) {
            return;
        }
        System.out.print(root.value + " ");
        traversePreorder(root.left);
        traversePreorder(root.right);

    }

    private void traverseInorder(Node x) {
        if (x == null) {
            return;
        }
        traverseInorder(x.left);
        System.out.print(x.value + " ");
        traverseInorder(x.right);

    }

    public void traverseInorder() {
        if (root == null) {
            return;
        }
        traverseInorder(root.left);
        System.out.print(root.value + " ");
        traverseInorder(root.right);

    }

    private void traversePostorder(Node x) {
        if (x == null) {
            return;
        }

        traversePostorder(x.left);
        traversePostorder(x.right);
        System.out.print(x.value + " ");

    }

    public void traversePostorder() {
        if (root == null) {
            return;
        }
        traversePostorder(root.left);
        traversePostorder(root.right);
        System.out.print(root.value + " ");

    }

    private void printDescending(Node x) {
        if (x == null) {
            return;
        }
        printDescending(x.right);
        System.out.print(x.value + " ");
        printDescending(x.left);


    }

    public void printDescending() {
        if (root == null) {
            return;
        }
        printDescending(root.right);
        System.out.print(root.value + " ");
        printDescending(root.left);


    }
}

import java.util.ArrayList;

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
        traversePreorder(root);
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
        traverseInorder(root);
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
        traversePostorder(root);

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
        printDescending(root);
    }

    public boolean equals(BinarySearchTree tree) {
        return equals(root, tree.root);
    }

    private boolean equals(Node root1, Node root2) {
        if (root1 == null && root2 == null) {
            return true;
        } else if (root1 == null || root2 == null) {
            return false;
        }
        return (root1.value == root2.value && equals(root1.right, root2.right) && equals(root1.left, root2.left));

    }

    public int height() {
        return height(root);
    }

    private int height(Node x) {
        if (x == null) {
            return 0;
        }
        return 1 + Math.max(height(x.right), height(x.left));
    }

    public ArrayList<Integer> kthElementFromRoot(int distance) {
        ArrayList<Integer> list = new ArrayList<>();
        getElement(distance, 0, list, root);
        return list;
    }

    private void getElement(int distance, int count, ArrayList<Integer> list, Node x) {
        if (x == null) {
            return;
        }
        if (count == distance) {
            list.add(x.value);
            return;
        }
        getElement(distance, count + 1, list, x.left);
        getElement(distance, count + 1, list, x.right);

    }

    public void levelOrder() {
        levelOrder(root);
    }

    private void levelOrder(Node x) {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < height() + 1; i++) {
            list.addAll(kthElementFromRoot(i));
        }
        System.out.println(list);
    }
}

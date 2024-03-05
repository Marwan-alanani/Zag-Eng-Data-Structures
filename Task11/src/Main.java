// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        BinarySearchTree tree = new BinarySearchTree();
        tree.insert(45);
        tree.insert(15);
        tree.insert(79);
        tree.insert(10);
        tree.insert(20);
        tree.insert(55);
        tree.insert(90);
        tree.insert(10);
        tree.insert(50);
        tree.traverseInorder();
        System.out.println();
        tree.traversePreorder();
        System.out.println();
        tree.traversePostorder();
        System.out.println();
        tree.printDescending();
    }
}
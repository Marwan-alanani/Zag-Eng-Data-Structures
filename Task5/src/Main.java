// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        GenericLinkedList<Integer> list = new GenericLinkedList<>();
        list.addFirst(2);
        list.addFirst(5);
        list.addFirst(6);
        list.printElements();
        list.reverse();
        list.printElements();
    }
}
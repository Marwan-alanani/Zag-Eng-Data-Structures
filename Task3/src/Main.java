// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        DynamicArray array = new DynamicArray(10);
        array.insert(10);
        array.insert(20);
        array.insert(15);
        array.insert(20);
        array.printArray();
        System.out.println(array.indexOf(20));


    }
}
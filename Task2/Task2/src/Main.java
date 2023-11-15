import java.util.ArrayList;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        ArrayList<Character> listOfCharacters = new ArrayList<Character>(){
            {
                add('d');
                add('o');
                add('n');
                add('e');
            }};
        ArrayList<Integer> listOfNumbers = new ArrayList<Integer>(){
            {
               add(1);
               add(2);
               add(3);
               add(4);
            }};
        printList(listOfCharacters);
        printList(listOfNumbers);


    }

    public static <T> void printList(ArrayList<T> data){
        data.forEach(element->{
            System.out.print(element);
        });
        System.out.println();

    }
}
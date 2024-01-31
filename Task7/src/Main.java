
import java.util.Scanner;
import java.util.Stack;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        int no = input.nextInt();
        input.nextLine();
        String[] children;
        String allChildren = input.nextLine();
        children = allChildren.split(" ");
        int tosses = input.nextInt();
        System.out.println("The winner is: " + hotPotato(children, tosses));

    }

    public static void reverse(QueueLinkedList queue) {
        Stack<Integer> st = new Stack<>();
        while (!queue.isEmpty()) {
            st.push((int) queue.dequeue());
        }
        while (!st.isEmpty()) {
            System.out.print(st.pop() + " ");
        }
        System.out.println();

    }

    public static String hotPotato(String[] children, int tosses) {
        QueueLinkedList<String> queue = new QueueLinkedList<>();
        for (String name : children) {
            queue.enqueue(name);
        }

        while(queue.size()>1)
        {
            for(int i=0;i<tosses;i++)
            {
                queue.enqueue(queue.dequeue());
            }
            queue.dequeue();
        }
        return queue.dequeue();
    }
}
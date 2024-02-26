import java.util.HashMap;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {

        HashTableLinear table = new HashTableLinear(1);
        table.put(0,"zero");
        table.put(1,"one");
        table.put(2,"two");
        table.put(4,"three");
        table.put(9,"four");
        table.put(10,"ten");
        table.put(10,"ten twice");
        table.put(1000,"thousand");
        System.out.println(table.get(10));

        HashTableChaining table2 = new HashTableChaining(2);
        table2.put(1,"one");
        table2.put(1,"one twice");
        table2.put(2,"two");
        System.out.println(table2.get(1));
        table2.remove(2);
        getOccurences("The man, the myth, the legend");
        System.out.println(getFirstNonRepeating("The man, the myth, the legend"));
        int[] numbers = {1,2,2,3,3,3,4};
        System.out.println(getMostRepeated(numbers));



    }
    public static void getOccurences(String s){
        HashMap<Character,Integer> hashTable = new HashMap<>();
        for(char ch:s.toCharArray())
        {
            ch = Character.toLowerCase(ch);
            if(hashTable.containsKey(ch)){
                hashTable.put(ch,hashTable.get(ch)+1);
            }
            else
            {
                hashTable.put(ch,1);
            }
        }
        System.out.println(hashTable);

    }
    public static char getFirstNonRepeating(String s)
    {
        HashMap<Character,Integer> hashTable = new HashMap<>();
        for(char ch:s.toCharArray())
        {
            ch = Character.toLowerCase(ch);
            if(hashTable.containsKey(ch)){
                hashTable.put(ch,hashTable.get(ch)+1);
            }
            else
            {
                hashTable.put(ch,1);
            }
        }
        for(char ch:s.toCharArray()){
            ch = Character.toLowerCase(ch);
            if( hashTable.get(ch) == 1)
                return ch;
        }
        return '\0';
    }
    public static int getMostRepeated(int[] numbers) //O(N)
    {
        HashMap<Integer,Integer> hashTable = new HashMap<>();
        int max = numbers[0];
        for(int number:numbers)
        {
            if(hashTable.containsKey(number)){
                hashTable.put(number,hashTable.get(number)+1);
                if( hashTable.get(max) < hashTable.get(number))
                {
                    max = number;
                }
            }
            else
            {

                hashTable.put(number,1);
            }
        }
        return max;
    }
}
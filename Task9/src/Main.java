// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        nonRepeating("my name is marwan");
    }

    public static void nonRepeating(String s) {
        int[] freq = new int[26];
        for(int i=0;i<s.length();i++){
            int index =  Character.toLowerCase(s.charAt(i)) - 97;
            if(index<0 || index>25){
                continue;
            }
            freq[index]++;
        }
        for(int i=0;i<s.length();i++){
            int index =  Character.toLowerCase(s.charAt(i)) - 97;
            if(index<0 || index>25){
                continue;
            }
            if (freq[index] == 1){
                System.out.println(s.charAt(i));
                break;
            }
        }
    }
}

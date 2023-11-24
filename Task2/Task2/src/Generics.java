

public class Generics {
    public static Integer reverse(Integer no) {
        char[] numbersArray = no.toString().toCharArray();
        String number = "";
        for (int i = numbersArray.length - 1; i > -1; i--) {
            number += numbersArray[i];
        }

        return Integer.parseInt(number);
    }

    public static int randomInt(Integer no) {
        double random = Math.random() * (no + 1);
        random = Math.floor(random);
        return (int) (random);
    }

    public static int randomInt(Integer max, Integer min) {
        if (min > max) {
            System.out.println("Incorrect use of function.");
            return 1;
        }
        return min + randomInt((max - min));
    }

    public static Character randomCharacter() {
        return (char) (randomInt((int) ('Z'), (int) ('A')));
    }

    public static <T> void printData(T[] data) {
        for (T element : data) {
            System.out.print(element);
        }
        System.out.println();
    }
}

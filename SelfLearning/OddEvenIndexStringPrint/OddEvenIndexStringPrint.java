import java.io.*;
import java.util.*;

public class OddEvenIndexStringPrint {

    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        int num = scanner.nextInt();
        scanner.nextLine();
        for (int i = 0; i < num; i++) {
            String input = scanner.nextLine();
            String output = printStringSeparateByOddEvenIndex(input);
            System.out.println(output);
        }

        scanner.close();
    }

    private static String printStringSeparateByOddEvenIndex(String s) {
        StringBuilder oddIndexString = new StringBuilder();
        StringBuilder evenIndexString = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            if (i % 2 != 0) {
                oddIndexString.append(s.charAt(i));
            } else {
                evenIndexString.append(s.charAt(i));
            }
        }

        evenIndexString.append(" ");
        
        return evenIndexString.toString() + oddIndexString.toString();
    }
}
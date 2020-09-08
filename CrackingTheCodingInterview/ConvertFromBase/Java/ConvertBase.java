package CrackingTheCodingInterview.ConvertFromBase.Java;

import java.util.Scanner;

public class ConvertBase {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Type string number: ");
        String inputNumber = scanner.nextLine();
        System.out.println("Type base: ");
        int inputBase = scanner.nextInt();
        scanner.close();
        System.out.println(convertBase(inputNumber, inputBase));
    }

    public static int convertBase(String num, int base) {
        if (base < 2 || (base > 10 && base != 16))
            return -1;
        int value = 0;
        for (int i = num.length() - 1; i >= 0; i--) {
            int digit = digitToValue(num.charAt(i));
            if (digit < 0 || digit >= base) {
                return -1;
            }
            int exponential = num.length() - 1 - i;
            value += digit * Math.pow(base, exponential);
        }
        return value;
    }

    public static int digitToValue(char c) {
        String s = Character.toString(c);
        if (Character.isDigit(c)) {
            return Integer.parseInt(s);
        }
        switch (s.toUpperCase()) {
            case "A":
                return 10;
            case "B":
                return 11;
            case "C":
                return 12;
            case "D":
                return 13;
            case "E":
                return 14;
            case "F":
                return 15;
            default:
                return -1;
        }
    }
}

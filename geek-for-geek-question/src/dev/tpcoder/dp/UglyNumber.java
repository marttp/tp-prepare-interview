package dev.tpcoder.dp;

/*
* Ugly numbers are numbers whose only prime factors are 2, 3 or 5.
* The sequence 1, 2, 3, 4, 5, 6, 8, 9, 10, 12, 15, …
* shows the first 11 ugly numbers. By convention, 1 is included.
* */
public class UglyNumber {
    public static void main(String[] args) {
        System.out.println(isUgly(300));
    }

    public static boolean isUglyShort(int num) {
        if (num == 0) return false;
        if (num == 1) return true;

        while (num % 2 == 0) num /= 2;
        while (num % 3 == 0) num /= 3;
        while (num % 5 == 0) num /= 5;

        return num == 1;
    }

    public static boolean isUgly(int num) {
        if (num == 0) return false;
        if (num == 1) return true;

        int flag = 1;

        while (true) {

            flag = 1;

            if (num % 2 == 0) {
                num /= 2;
                flag = 0;
                continue;
            }

            if (num % 3 == 0) {
                num /= 3;
                flag = 0;
                continue;
            }

            if (num % 5 == 0) {
                num /= 5;
                flag = 0;
                continue;
            }

            if (flag == 1) break;
        }

        return num == 1;
    }
}

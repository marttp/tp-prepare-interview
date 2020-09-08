package dev.tpcoder.dp;

import java.util.Scanner;

public class Fibonacci {

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Insert N of Fibonacci: ");
        int n = scanner.nextInt();
        System.out.println(fibonacciNoDp(n));
        System.out.println(fibonacciWithDp(n));
    }

    private static int fibonacciNoDp(int n) {
        if (n <= 1) return n;
        return fibonacciNoDp(n - 1) + fibonacciNoDp(n - 2);
    }

    private static int fibonacciWithDp(int n) {
        if (n < 1) {
            return n;
        }
        int[] dp = new int[n + 1];
        dp[1] = 1;

        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        return dp[n];
    }
}

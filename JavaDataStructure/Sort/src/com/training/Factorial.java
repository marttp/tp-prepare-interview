package com.training;

public class Factorial {

    public static int factorial(int num) {
//        return iterativeFactorial(num);
        return recursiveFactorial(num);
    }

    private static int iterativeFactorial(int num) {
        if (num == 0) {
            return 1;
        }
        int factorial = 1;
        for (int i = 1; i <= num; i++) {
            factorial *= i;
        }
        return factorial;
    }

    private static int recursiveFactorial(int num) {
        if (num == 0) {
            return 1;
        }
        return num * recursiveFactorial(num - 1);
    }
}

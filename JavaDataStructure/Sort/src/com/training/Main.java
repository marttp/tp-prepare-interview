package com.training;

import com.training.sort.*;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        // write your code here
        int[] intArray = new int[10];
        for (int i = 0; i < intArray.length; i++) {
//            intArray[i] = (int)(Math.random() * 10);
            intArray[i] = (int)(Math.random() * 10000);
        }
        Sort sort;
//        sort = new BubbleSort(intArray);
//        sort = new SelectionSort(intArray);
//        sort = new InsertionSort(intArray);
//        sort = new ShellSort(intArray);
//        sort = new MergeSort(intArray);
//        sort = new QuickSort(intArray);
//        sort = new CountingSort(intArray);
        sort = new RadixSort(intArray);
        sort.sort();

//        Arrays.sort(intArray);
        /**
         * Parallel sort more efficient on massive of data
         */
//        Arrays.parallelSort(intArray);

        System.out.println(Arrays.toString(intArray));
//        int factorialResult = Factorial.factorial(5);
//        System.out.println(factorialResult);
    }

}

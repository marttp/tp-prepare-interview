package com.training;

import com.training.sort.*;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
//        factorialTopic();
        sortingTopic();
    }

    private static void sortingTopic() {
        int[] intArray = new int[10];
        for (int i = 0; i < intArray.length; i++) {
            // Using on counting sort
            // intArray[i] = (int)(Math.random() * 10);
            intArray[i] = (int) (Math.random() * 10000);
        }

        Sort sort;
//        sort = new BubbleSort(intArray);
//        sort = new SelectionSort(intArray);
//        sort = new InsertionSort(intArray);
//        sort = new ShellSort(intArray);
        sort = new MergeSort(intArray);
//        sort = new QuickSort(intArray);
//        sort = new CountingSort(intArray);
//        sort = new RadixSort(intArray);
        sort.sort();

//        Arrays.sort(intArray);
        /**
         * Parallel sort more efficient on massive of data
         */
//        Arrays.parallelSort(intArray);
        System.out.println(Arrays.toString(intArray));
    }

    private static void factorialTopic() {
        int factorialResult = Factorial.factorial(5);
        System.out.println(factorialResult);
    }

}

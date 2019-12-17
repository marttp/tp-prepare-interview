package com.training;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        // write your code here
        int[] intArray = new int[10];
        for (int i = 0; i < intArray.length; i++) {
            intArray[i] = (int)(Math.random() * 1000);
        }

//        bubbleSort(intArray);
        selectionSort(intArray);
        System.out.println(Arrays.toString(intArray));

    }

    private static void swap(int[] array, int i, int j) {
        if (i == j) {
            return;
        }
        int tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }

    // O(n^2) Quadratic
    private static void bubbleSort(int[] unsortedArray) {
        for (int i = unsortedArray.length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (unsortedArray[j] > unsortedArray[j + 1]) {
                    swap(unsortedArray, j, j + 1);
                }
            }
        }
    }

    // O(n^2) Quadratic
    private static void selectionSort(int[] unsortedArray) {
        for (int i = 0; i < unsortedArray.length; i++) {
            int minIndexEachRound = i;
            for (int j = i+1; j < unsortedArray.length; j++) {
                if (unsortedArray[minIndexEachRound] > unsortedArray[j]) {
                    minIndexEachRound = j;
                }
            }
            swap(unsortedArray, i, minIndexEachRound);
        }
    }
}

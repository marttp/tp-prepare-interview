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
//        selectionSort(intArray);
//        insertionSort(intArray);
        shellSort(intArray);
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

    // O(n^2) Quadratic : Unstable
    private static void bubbleSort(int[] unsortedArray) {
        for (int i = unsortedArray.length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (unsortedArray[j] > unsortedArray[j + 1]) {
                    swap(unsortedArray, j, j + 1);
                }
            }
        }
    }

    // O(n^2) Quadratic : Unstable
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

    // O(n^2) Quadratic
    private static void insertionSort(int[] unsortedArray) {
        for (int firstUnsortedIndex = 1; firstUnsortedIndex < unsortedArray.length; firstUnsortedIndex++) {
            int element = unsortedArray[firstUnsortedIndex];
            int index;
            for (index = firstUnsortedIndex; index > 0 && unsortedArray[index - 1] > element; index--) {
                unsortedArray[index] = unsortedArray[index - 1];
            }
            unsortedArray[index] = element;
        }
    }

    // O(n^2) Worst case but can perform much better : Unstable
    private static void shellSort(int[] unsortedArray) {
        // Knuth Sequence : k
        // Gap calculate : (3^k -1 ) / 2
        for (int gap = unsortedArray.length / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < unsortedArray.length; i++) {
                int element = unsortedArray[i];
                int index = i;
                while (index >= gap && unsortedArray[index - gap] > element) {
                    unsortedArray[index] = unsortedArray[index - gap];
                    index -= gap;
                }
                unsortedArray[index] = element;
            }
        }
    }
}

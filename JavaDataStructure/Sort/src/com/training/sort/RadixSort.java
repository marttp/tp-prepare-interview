package com.training.sort;

import java.util.Arrays;

public class RadixSort extends Sort {

    public RadixSort(int[] array) {
        this.array = array;
    }

    @Override
    public void sort() {
        radixSort(10, 4);
    }

    private void radixSort(int radix, int digit) {
        // Iterate will loop over array. digit is up to maximum of possible value
        for (int i = 0; i < digit; i++) {
            radixSingleSort(i, radix);
        }
    }

    private void radixSingleSort(int position, int radix) {
        int numItems = this.array.length;
        int[] countArray = new int[radix];

        for (int value : this.array) {
            countArray[getDigit(position, value, radix)]++;
        }

//        System.out.println("countArray");
//        System.out.println(Arrays.toString(countArray));

        // Count all of it
        for (int j = 1; j < radix; j++) {
            countArray[j] += countArray[j - 1];
        }

//        System.out.println("array");
//        System.out.println(Arrays.toString(this.array));
//        System.out.println("countArray");
//        System.out.println(Arrays.toString(countArray));

        int[] temp = new int[numItems];
        for (int tempIndex = numItems - 1; tempIndex >= 0; tempIndex--) {
            int digit = getDigit(position, this.array[tempIndex], radix);
            // Use count array to specific index of tmp value
            int index = --countArray[digit];
            temp[index] = this.array[tempIndex];
        }

//        System.out.println("countArray");
//        System.out.println(Arrays.toString(countArray));
//        System.out.println("temp");
//        System.out.println(Arrays.toString(temp));
//        System.out.println();

        for (int tempIndex = 0; tempIndex < numItems; tempIndex++) {
            this.array[tempIndex] = temp[tempIndex];
        }
    }

    private int getDigit(int position, int value, int radix) {
        return value / (int) Math.pow(radix, position) % radix;
    }
}

package com.training.sort;

public class CountingSort extends Sort {
    public CountingSort(int[] array) {
        this.array = array;
    }

    // O(n)
    @Override
    public void sort() {
        int min = 0;
        int max = 9;
        int[] countArray = new int[max - min + 1];
        for (int value : this.array) {
            countArray[value]++;
        }

        int countAll = 0;
        for (int j = min; j <= max; j++) {
            int count = countArray[j];
            while (count > 0) {
                this.array[countAll++] = j;
                count--;
            }
        }
    }
}

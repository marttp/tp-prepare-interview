package com.training.sort;

public class InsertionSort extends Sort {

    private int[] array;
    public InsertionSort(int[] array) {
        this.array = array;
    }

    // O(n^2) Quadratic
    @Override
    public void sort() {
        for (int firstUnsortedIndex = 1; firstUnsortedIndex < this.array.length; firstUnsortedIndex++) {
            int element = this.array[firstUnsortedIndex];
            int index;
            for (index = firstUnsortedIndex; index > 0 && this.array[index - 1] > element; index--) {
                this.array[index] = this.array[index - 1];
            }
            this.array[index] = element;
        }
    }
}

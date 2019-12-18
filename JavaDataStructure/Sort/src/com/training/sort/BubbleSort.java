package com.training.sort;

public class BubbleSort extends Sort {
    public BubbleSort(int[] array) {
        this.array = array;
    }

    // O(n^2) Quadratic : Unstable
    @Override
    public void sort() {
        for (int i = this.array.length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (this.array[j] > this.array[j + 1]) {
                    swap(j, j + 1);
                }
            }
        }
    }
}

package com.training.sort;

public class SelectionSort extends Sort {
    public SelectionSort(int[] array) {
        this.array = array;
    }

    // O(n^2) Quadratic : Unstable
    @Override
    public void sort() {
        for (int i = 0; i < this.array.length; i++) {
            int minIndexEachRound = i;
            for (int j = i + 1; j < this.array.length; j++) {
                if (this.array[minIndexEachRound] > this.array[j]) {
                    minIndexEachRound = j;
                }
            }
            swap(i, minIndexEachRound);
        }
    }
}

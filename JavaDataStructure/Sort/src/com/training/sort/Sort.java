package com.training.sort;

public abstract class Sort {

    int[] array;

    void swap(int i, int j) {
        if (i == j) {
            return;
        }
        int tmp = this.array[i];
        this.array[i] = this.array[j];
        this.array[j] = tmp;
    }

    public abstract void sort();
}

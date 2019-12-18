package com.training.sort;

public abstract class Sort {

    int[] array;

    void swap(int[] array, int i, int j) {
        if (i == j) {
            return;
        }
        int tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }

    public abstract void sort();
}

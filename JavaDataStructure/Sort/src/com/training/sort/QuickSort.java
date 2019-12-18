package com.training.sort;

import java.util.Arrays;

/**
 * Divide & Conquer algorithm
 * Recursive algorithm
 * find pivot to partition
 */
public class QuickSort extends Sort {

    private int[] array;
    public QuickSort(int[] array) {
        this.array = array;
    }

    // O(n log n) : Unstable
    @Override
    public void sort() {
        quickSort(0, this.array.length);
    }

    private void quickSort(int start, int end) {
        if (end - start < 2) {
            return;
        }
        int partitionIndex = partition(start, end);
        quickSort(start, partitionIndex);
        quickSort(partitionIndex + 1, end);
    }

    private int partition(int start, int end) {
        int pivot = this.array[start];
        int tmpStart = start;
        int tmpEnd = end;

        while (tmpStart < tmpEnd) {
            while (tmpStart < tmpEnd && this.array[--tmpEnd] >= pivot);
            if (tmpStart < tmpEnd ) {
                this.array[tmpStart] = this.array[tmpEnd];
            }
            while (tmpStart < tmpEnd && this.array[++tmpStart] <= pivot);
            if (tmpStart < tmpEnd) {
                this.array[tmpEnd] = this.array[tmpStart];
            }
        }

        this.array[tmpEnd] = pivot;
        return tmpEnd;
    }
}

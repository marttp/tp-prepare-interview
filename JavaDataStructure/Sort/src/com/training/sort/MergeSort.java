package com.training.sort;

/**
 * Divide & Conquer algorithm
 * Recursive algorithm
 * Split & Merging
 * Splitting is logical. not create new array
 */
public class MergeSort extends Sort {

    private int[] array;
    public MergeSort(int[] array) {
        this.array = array;
    }

    // O(n log n): Dividing the array in half during splitting : Stable
    @Override
    public void sort() {
        mergeSort(0, array.length);
    }

    private void mergeSort(int start, int end) {
        // if element more than one just break the function
        if (end - start >= 2) {
            // find mid index for splitting array
            int midIndex = (int)(start + end)/2;
            mergeSort(start, midIndex);
            mergeSort(midIndex, end);
            merge(start, midIndex, end);
        }

    }

    private void merge(int start, int mid, int end) {
        if (this.array[mid - 1] > this.array[mid]) {
            int i = start;
            int j = mid;
            int tempIndex = 0;
            int[] temp = new int[end - start];
            while(i < mid && j < end) {
                temp[tempIndex++] = this.array[i] <= this.array[j] ? this.array[i++] : this.array[j++];
            }
            System.arraycopy(this.array, i, this.array, start + tempIndex, mid - i);
            System.arraycopy(temp, 0, this.array, start, tempIndex);
        }
    }

}

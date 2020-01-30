package com.training.sort;

/**
 * Divide & Conquer algorithm
 * Recursive algorithm
 * Split & Merging
 * Splitting is logical. not create new array
 */
public class MergeSort extends Sort {
    public MergeSort(int[] array) {
        this.array = array;
    }

    // O(n log n): Dividing the array in half during splitting : Stable
    @Override
    public void sort() {
        mergeSort(0, array.length, "asc");
    }

    private void mergeSort(int start, int end, String type) {
        // if element more than one just break the function
        if (end - start >= 2) {
            // find mid index for splitting array
            int midIndex = (int) (start + end) / 2;
            mergeSort(start, midIndex, type);
            mergeSort(midIndex, end, type);
            merge(start, midIndex, end, type);
        }

    }

    private void merge(int start, int mid, int end, String type) {
        boolean conditionSorting = type.equals("asc") ? this.array[mid - 1] > this.array[mid] : this.array[mid - 1] < this.array[mid];
        if (conditionSorting) {
            int i = start;
            int j = mid;
            int tempIndex = 0;
            int[] temp = new int[end - start];
            while (i < mid && j < end) {
                boolean condition = type.equals("asc") ? this.array[i] <= this.array[j] : this.array[i] >= this.array[j];
                temp[tempIndex++] = condition ? this.array[i++] : this.array[j++];
            }
            System.arraycopy(this.array, i, this.array, start + tempIndex, mid - i);
            System.arraycopy(temp, 0, this.array, start, tempIndex);
        }
    }

}

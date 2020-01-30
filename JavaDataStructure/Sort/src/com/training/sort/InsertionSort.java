package com.training.sort;

public class InsertionSort extends Sort {
    public InsertionSort(int[] array) {
        this.array = array;
    }

    // O(n^2) Quadratic
    @Override
    public void sort() {
//        iteration();
        recursion(this.array.length);
    }

    public void iteration() {
        for (int firstUnsortedIndex = 1; firstUnsortedIndex < this.array.length; firstUnsortedIndex++) {
            int element = this.array[firstUnsortedIndex];
            int index;
            for (index = firstUnsortedIndex; index > 0 && this.array[index - 1] > element; index--) {
                this.array[index] = this.array[index - 1];
            }
            this.array[index] = element;
        }
    }

    public void recursion(int numItems) {
        if (numItems < 2) {
            return;
        }
        recursion(numItems - 1);
        int newElement = this.array[numItems - 1];
        int index;
        for (index = numItems - 1; index > 0 && this.array[index - 1] > newElement; index--) {
            this.array[index] = this.array[index - 1];
        }
        this.array[index] = newElement;
    }
}

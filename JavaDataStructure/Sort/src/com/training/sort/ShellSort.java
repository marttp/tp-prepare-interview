package com.training.sort;

public class ShellSort extends  Sort {

    public ShellSort(int[] array) {
        this.array = array;
    }

    // O(n^2) Worst case but can perform much better : Unstable
    @Override
    public void sort() {
        // Knuth Sequence : k
        // Gap calculate : (3^k -1 ) / 2
        for (int gap = this.array.length / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < this.array.length; i++) {
                int element = this.array[i];
                int index = i;
                while (index >= gap && this.array[index - gap] > element) {
                    this.array[index] = this.array[index - gap];
                    index -= gap;
                }
                this.array[index] = element;
            }
        }
    }
}

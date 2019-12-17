package com.training;

public class Main {

    public static void main(String[] args) {
        // write your code here
        int[] intArray = new int[7];
        intArray[0] = 1;
        intArray[1] = 20;
        intArray[2] = -52;
        intArray[3] = 17;
        intArray[4] = -8;
        intArray[5] = 9;
        intArray[6] = -22;

        int index = -1;
        // O(n)
        for (int i = 0; i < intArray.length; i++) {
            // System.out.println(intArray[i]);
            if (intArray[i] == 17) {
                index = i;
                break;
            }
        }

        System.out.println("index = " + index);

        /**
         * Time Complexity
         * Retrieve with index = O(1)
         * Retrieve without index = O(n)
         * Add element into full array = O(n)
         * Add element to the end of array = O(1)
         * Insert & Update with specific index = O(1)
         * Delete element with index to null = O(1)
         * Delete element with index and shift = O(n)
         */
    }
}

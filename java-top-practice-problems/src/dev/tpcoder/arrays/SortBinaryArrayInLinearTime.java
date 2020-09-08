package dev.tpcoder.arrays;

import java.util.Arrays;

public class SortBinaryArrayInLinearTime {
    // Sort binary array in linear time
    public static void main(String[] args) {
        int[] A = {0, 0, 1, 0, 1, 1, 0, 1, 0, 0};
        sortLinearTime(A);
        // print the rearranged array
        System.out.println(Arrays.toString(A));
    }

    private static void sortLinearTime(int[] a) {
        int left = 0;
        int right = a.length - 1;
        while (left < right) {
            while (left < right && a[left] == 0) {
                left++;
            }
            while (left < right && a[right] == 1) {
                right--;
            }
            int tmp = a[left];
            a[left++] = a[right];
            a[right--] = tmp;
        }
    }

}

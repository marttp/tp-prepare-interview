package dev.tpcoder.arrays;

import java.util.Arrays;
import java.util.HashMap;

public class FindPairWithGivenSum {
    // Given an unsorted array integers, find a pair with given sum in it
    public static void main(String[] args) {
        int[] A = { 8, 7, 2, 5, 3, 1 };
        int sum = 10;

        findPairNaiveApproach(A, sum);

//        findPairSorting(A, sum);

        findPairWithHashMap(A, sum);
    }

    // Time Complexity - O(n^2)
    // Space Complexity - O(1)
    private static void findPairNaiveApproach(int[] a, int sum) {
        for (int i = 0; i < a.length - 1; i++) {
            for (int j = 0; j < a.length; j++) {
                if (a[i] + a[j] == sum) {
                    System.out.println("Pair found at index: " + i + " and " + j);
                    return;
                }
            }
        }
        System.out.println("Pair not found");
    }

    // Time Complexity - O(n log n)
    // Space Complexity - O(1)
    private static void findPairSorting(int[] a, int sum) {
        Arrays.sort(a);
        int left = 0;
        int right = a.length - 1;

        while (left < right) {
            int value = a[left] + a[right];
            if (value == sum) {
                System.out.println("Pair found at index: " + left + " and " + right);
                return;
            } else if (value > sum) {
                right--;
            } else {
                left++;
            }
        }
        System.out.println("Pair not found");
    }

    private static void findPairWithHashMap(int[] a, int sum) {
        HashMap<Integer, Integer> mapIndex = new HashMap<>();
        for (int i = 0; i < a.length; i++) {
            if (mapIndex.containsKey(a[i])) {
                if (mapIndex.get(a[i]) != i) {
                    System.out.println("Pair found at index: " + mapIndex.get(a[i]) + " and " + i);
                    return;
                }
            }
            mapIndex.put(sum - a[i], i);
        }
        System.out.println("Pair not found");
    }
}

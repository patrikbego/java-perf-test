package com.sonar.algo;

import java.util.Arrays;

import static com.sonar.algo.MiddlePivotQuickSort.recursionCount;


public class LeftPivotQuickSort {
    public static int[] sort(int[] arrayInt, int l) {
        if (arrayInt != null && arrayInt.length > 1) {
            int pivot = arrayInt[l - 1];
            int i = l - 2;

            for (int j = l - 2; j >= 0; j--) {
                if (arrayInt[j] > pivot) {
                    arrayInt = swap(arrayInt, j, i);
                    i--;
                }
            }
            arrayInt = swap(arrayInt, l - 1, i + 1);
            if (true) {
                int[] unsortedLeftArray = Arrays.copyOfRange(arrayInt, 0, i + 1);
                recursionCount = recursionCount + unsortedLeftArray.length - 1;
                int[] leftArray = sort(unsortedLeftArray, unsortedLeftArray.length);
                for (int k = 0; k < leftArray.length; k++) {
                    arrayInt[k] = leftArray[k];
                }

                int[] unsortedRightArray = Arrays.copyOfRange(arrayInt, i + 1, arrayInt.length);
                recursionCount = recursionCount + unsortedRightArray.length - 1;
                int[] rightArray = sort(unsortedRightArray, unsortedRightArray.length);
                for (int k = 0; k < rightArray.length; k++) {
                    arrayInt[leftArray.length + k] = rightArray[k];
                }
            }

            System.out.println("Nr. of Recursions : " + recursionCount);

        }
        return arrayInt;
    }

    private static int[] swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
        return arr;
    }

}

package com.sonar.algo;

import java.util.Arrays;

import static com.sonar.algo.NewQuickSort.recursionCount;


public class QuickSortOpti {
    public static int[] sort(int[] arrayInt, int l) {
//        recursionCount = recursionCount + arrayInt.length -1;
        if (arrayInt != null && arrayInt.length > 1) {
            int pivot = arrayInt[l];
            int i = l + 1;

            for (int j = l + 1; j < arrayInt.length; j++) {
                if (arrayInt[j] < pivot) {
                    arrayInt = swap(arrayInt, j, i);
                    i++;
                }
            }
            arrayInt = swap(arrayInt, l, i - 1);
            if (i > l) {
//
                int[] unsortedLeftArray = Arrays.copyOfRange(arrayInt, 0, i);
                recursionCount = recursionCount + unsortedLeftArray.length -1;
                int[] leftArray = sort(unsortedLeftArray, l);
                for (int k = 0; k < leftArray.length; k++) {
                    arrayInt[k] = leftArray[k];
                }

                int[] unsortedRightArray = Arrays.copyOfRange(arrayInt, i, arrayInt.length);
                recursionCount = recursionCount + unsortedLeftArray.length -1;
                int[] rightArray = sort(unsortedRightArray, l);
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

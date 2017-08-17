package com.sonar.algo;

import java.util.Arrays;

import static com.sonar.algo.NewQuickSort.recursionCount;


public class QuickSortOpti {
    public static int[] sort(int[] arrayInt) {

        if (arrayInt != null && arrayInt.length > 0) {
            int pivotIndex = 0;
            int pivot = arrayInt[pivotIndex];
            int leftPartitionSize = 0;
            int rightPartitionSize = 0;

            for (int index = 0; index < arrayInt.length; index++) {
                if (index != pivotIndex) {
                    if (arrayInt[index] < pivot) {
                        arrayInt = swap(arrayInt, index, pivotIndex);
                        pivotIndex = index;
                        leftPartitionSize++;
                    } else {
                        rightPartitionSize++;
                    }
                }
            }

            int[] leftArray = new int[0];
            if (leftPartitionSize > 0) {
                leftArray = sort(Arrays.copyOfRange(arrayInt, 0, leftPartitionSize));
                recursionCount ++;
            }

            int[] rightArray = new int[0];
            if (rightPartitionSize > 0) {
                rightArray = sort(Arrays.copyOfRange(arrayInt, pivotIndex, arrayInt.length - 1));
                recursionCount ++;
            }

            arrayInt = new int[leftArray.length + rightArray.length];

            for (int i = 0; i < leftArray.length; i++) {
                arrayInt[i] = leftArray[i];
            }

            for (int i = 0; i < rightArray.length; i++) {
                arrayInt[leftArray.length + i] = rightArray[i];
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

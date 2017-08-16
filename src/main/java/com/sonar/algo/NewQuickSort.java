package com.sonar.algo;

import java.util.Arrays;

public class NewQuickSort {
    public static int[] sort(int[] arrayInt) {
        int[] finalArray = {};
        if (arrayInt.length > 0) {
            int pivotIndex = 0;
            int pivot = arrayInt[pivotIndex];
            int leftPartitionSize = 0;
            int rightPartitionSize = 0;
            int[] leftPartionArray = new int[arrayInt.length];
            int[] rightPartionArray = new int[arrayInt.length];

            for (int index = 0; index < arrayInt.length; index++) {
                int arrayElementValue = arrayInt[index];
                if (index != pivotIndex) {
                    if (arrayElementValue < pivot) {
                        leftPartionArray[leftPartitionSize] = arrayElementValue;
                        leftPartitionSize++;
                    } else {
                        rightPartionArray[rightPartitionSize] = arrayElementValue;
                        rightPartitionSize++;
                    }
                }
            }
            leftPartitionSize++;
            leftPartionArray[leftPartionArray.length - 1] = pivot;

            int[] temp = leftPartionArray;
            leftPartionArray = new int[leftPartitionSize];

            for (int j = 0; j < leftPartitionSize; j++) {
                leftPartionArray[j] = temp[j];
//            System.out.println("Left element : " + temp[j]);
            }

            temp = rightPartionArray;
            rightPartionArray = new int[rightPartitionSize];
            for (int j = 0; j < rightPartitionSize; j++) {
                rightPartionArray[j] = temp[j];
//            System.out.println("Right element : " + temp[j]);
            }

            if (leftPartionArray.length > 0)
                leftPartionArray = sort(leftPartionArray);
            if (rightPartionArray.length > 0 && leftPartionArray.length != 0)
                rightPartionArray = sort(rightPartionArray);

            finalArray = new int[leftPartionArray.length + rightPartionArray.length];

            System.arraycopy(leftPartionArray, 0, finalArray, 0, leftPartionArray.length);
            System.arraycopy(rightPartionArray, 0, finalArray, leftPartionArray.length, rightPartionArray.length);

            System.out.println(Arrays.toString(finalArray));
        }
        return finalArray;
    }

    static boolean areAllElementsEqual(int[] array) {
        int lastElement = array[array.length - 1];
        for (int i = 0; i < array.length; i++) {
            if (array[i] != lastElement)
                return false;
        }
        return true;
    }

    private static int[] swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
        return arr;
    }

}

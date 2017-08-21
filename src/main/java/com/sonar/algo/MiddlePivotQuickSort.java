package com.sonar.algo;

public class MiddlePivotQuickSort {

    static int recursionCount = 0;

    public static int[] sort(int[] arrayInt) {
        int[] finalArray = {};
        if (arrayInt != null && arrayInt.length > 0) {
            int pivotIndex = arrayInt.length % 2 == 0 ? ((arrayInt.length / 2) - 1) : (arrayInt.length / 2);
            int pivot = arrayInt[pivotIndex];
            int leftPartitionSize = 0;
            int rightPartitionSize = 0;

            int[] leftPartitionArray = new int[arrayInt.length];
            int[] rightPartitionArray = new int[arrayInt.length];

            for (int index = 0; index < arrayInt.length; index++) {
                int arrayElementValue = arrayInt[index];
                if (index != pivotIndex) {
                    if (arrayElementValue < pivot) {
                        leftPartitionArray[leftPartitionSize] = arrayElementValue;
                        leftPartitionSize++;
                    } else {
                        rightPartitionArray[rightPartitionSize] = arrayElementValue;
                        rightPartitionSize++;
                    }
                }
            }
            leftPartitionSize++;
            leftPartitionArray[leftPartitionSize - 1] = pivot;

            int[] temp = leftPartitionArray;
            leftPartitionArray = new int[leftPartitionSize];
            for (int j = 0; j < leftPartitionSize; j++) {
                leftPartitionArray[j] = temp[j];
            }

            temp = rightPartitionArray;
            rightPartitionArray = new int[rightPartitionSize];
            for (int j = 0; j < rightPartitionSize; j++) {
                rightPartitionArray[j] = temp[j];
            }

            if (leftPartitionArray.length > 1) {
                recursionCount = recursionCount + leftPartitionArray.length - 1;
                leftPartitionArray = sort(leftPartitionArray);
                recursionCount++;
            }
            if (rightPartitionArray.length > 0) {
                recursionCount = recursionCount + rightPartitionArray.length - 1;
                rightPartitionArray = sort(rightPartitionArray);
                recursionCount++;
            }


            finalArray = new int[leftPartitionArray.length + rightPartitionArray.length];

            for (int i = 0; i < leftPartitionArray.length; i++) {
                finalArray[i] = leftPartitionArray[i];
            }

            for (int i = 0; i < rightPartitionArray.length; i++) {
                finalArray[leftPartitionArray.length + i] = rightPartitionArray[i];
            }

            System.out.println("Nr. of Recursions : " + recursionCount);
        }
        return finalArray;
    }

    private static int[] swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
        return arr;
    }

}

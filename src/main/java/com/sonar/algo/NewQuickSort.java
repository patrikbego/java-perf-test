package com.sonar.algo;

public class NewQuickSort {
    public static int[] sort(int[] arrayInt) {
        int[] finalArray = {};
        if (arrayInt.length > 0) {
            int pivotIndex = 0;
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

            if (leftPartitionArray.length > 1)
                leftPartitionArray = sort(leftPartitionArray);
            if (rightPartitionArray.length > 0)
                rightPartitionArray = sort(rightPartitionArray);

            finalArray = new int[leftPartitionArray.length + rightPartitionArray.length];

            System.arraycopy(leftPartitionArray, 0, finalArray, 0, leftPartitionArray.length);
            System.arraycopy(rightPartitionArray, 0, finalArray, leftPartitionArray.length, rightPartitionArray.length);

//            System.out.println(Arrays.toString(finalArray));
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

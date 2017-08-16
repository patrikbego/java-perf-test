package com.sonar.algo;

/**
 * Created by begop on 27/07/2017.
 */
public class QuickSort {

    private int[] numbers;
    private int number;

    public void sort(int[] values) {
        // check for empty or null array
        if (values == null || values.length == 0) {
            return;
        }
        this.numbers = values;
        number = values.length;
        quicksort(0, number - 1);
    }

    private void quicksort(int low, int high) {
        int i = low, j = high;
        // Get the pivot element from the middle of the list
        int pivot = numbers[low + (high - low) / 2];

        // Divide into two lists
        while (i <= j) {
            // If the current value from the left list is smaller than the pivot
            // element then get the next element from the left list
            while (numbers[i] < pivot) {
                i++;
            }
            // If the current value from the right list is larger than the pivot
            // element then get the next element from the right list
            while (numbers[j] > pivot) {
                j--;
            }

            // If we have found a value in the left list which is larger than
            // the pivot element and if we have found a value in the right list
            // which is smaller than the pivot element then we exchange the
            // values.
            // As we are done we can increase i and j
            if (i <= j) {
                swap(i, j);
                i++;
                j--;
            }
        }
        // Recursion
        if (low < j)
            quicksort(low, j);
        if (i < high)
            quicksort(i, high);
    }

    public void party(int[] values) {
        // check for empty or null array
        if (values == null || values.length == 0) {
            return;
        }
        this.numbers = values;
        partition(0, values.length - 1);
    }

    private void partition(int leftIndex, int rightIndex) {
//            int pivot = numbers[leftIndex];
//            int i = leftIndex + 1;
//
//            for (int k = i; k <= rightIndex; k++) {
//                int currentNumber = numbers[k];
//                if (currentNumber < pivot) {
//                    swap(k, i);
//                    i++;
//                }
//            }
//            swap(leftIndex, i - 1);

        int pivot = numbers[leftIndex];

        for (int j = leftIndex + 1; j <= rightIndex; j++) {
            int currentNumberAfterPivot = numbers[j];
            if (currentNumberAfterPivot < pivot) {
                swap(j - 1, j);
            }
        }

        for (int d = 0; d < numbers.length - 1; d++) {
            if (numbers[d] > numbers[d + 1]) {
                partition(leftIndex, numbers.length - 1);
            }
        }
    }

    private void swap(int i, int j) {
        int temp = numbers[i];
        numbers[i] = numbers[j];
        numbers[j] = temp;
    }
}

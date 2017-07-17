package com.sonar.algo;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by patrik007 on 14/07/2017.
 */
public class Inversor {

    public List<Integer> reader(String filePath) {
        List<Integer> arrayList = new ArrayList<>();
        try {

            ClassLoader classLoader = getClass().getClassLoader();
            File file = new File(classLoader.getResource(filePath).getFile());
            BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file), "Cp1252"));

            String line;
            while ((line = br.readLine()) != null) {
                arrayList.add(Integer.parseInt(line));
            }
            br.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

        return arrayList;

    }

    public List<Integer> sorter(List<Integer> unsortedList) {

        for (int k = 0; k < unsortedList.size() - 1; k++) {
            for (int i = 0; i < unsortedList.size() - 1; i++) {
                if (unsortedList.get(k) < unsortedList.get(i)) {
                    int temp = unsortedList.get(k);
                    unsortedList.set(k, unsortedList.get(i));
                    unsortedList.set(i, temp);

                }
            }
        }
        return unsortedList;
    }

    public int[] sorter1(int[] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length; j++) {
                if (array[i] < array[j]) {
                    int temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;
                }
            }
        }
        return array;
    }

    private int[] numbers;
    private int[] helper;

    private int number;

    int recoursion = 0;

    public void sort(int[] values) {
        this.numbers = values;
        number = values.length;
        this.helper = new int[number];
        mergesort(0, number - 1);
        System.out.println("inversion : " + recoursion);
    }

    private void mergesort(int low, int high) {
        // check if low is smaller than high, if not then the array is sorted
        if (low < high) {
            // Get the index of the element which is in the middle
            int middle = low + (high - low) / 2;
            // Sort the left side of the array
            mergesort(low, middle);
            // Sort the right side of the array
            mergesort(middle + 1, high);
            // Combine them both
            merge(low, middle, high);
        }
    }

    private void merge(int low, int middle, int high) {
//        recoursion++;
        // Copy both parts into the helper array
        for (int i = low; i <= high; i++) {
            helper[i] = numbers[i];
        }


        int i = low;
        int j = middle + 1;
        int k = low;
        // Copy the smallest values from either the left or the right side back
        // to the original array
        while (i <= middle && j <= high) {
            if (helper[i] <= helper[j]) {
                numbers[k] = helper[i];
                i++;
            } else {
                numbers[k] = helper[j];
                j++;
                recoursion ++;
            }
            k++;

        }
        // Copy the rest of the left side of the array into the target array
        while (i <= middle) {
            numbers[k] = helper[i];
            k++;
//            recoursion ++;
            i++;
        }
//        recoursion ++;

    }

    public void quicksort(int[] values) {
        // check for empty or null array
        if (values ==null || values.length==0){
            return;
        }
        this.numbers = values;
        number = values.length;
        quicksort(0, number - 1);
    }

    private void quicksort(int low, int high) {
        int i = low, j = high;
        // Get the pivot element from the middle of the list
        int pivot = numbers[low + (high-low)/2];

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
                exchange(i, j);
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

    private void exchange(int i, int j) {
        int temp = numbers[i];
        numbers[i] = numbers[j];
        numbers[j] = temp;
    }

}

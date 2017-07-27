package com.sonar.algo;

import java.io.*;
import java.math.BigDecimal;
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

    public BigDecimal countHigherPairs(int[] array) {
        BigDecimal counter = BigDecimal.ZERO;

        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length; j++) {
                if (array[i] > array[j] && i < j) {
//                    System.out.println("array[i] > array[j] " + array[i] + " > " + array[j]);
                    counter.add(BigDecimal.ONE);
                }

            }
        }
        return counter;
    }

    private int[] merge(int[] a, int[] b) {
        int[] c = new int[a.length + b.length];
        int i = 0, j = 0;
        for (int k = 0; k < c.length; k++) {

            if (i >= a.length) {
                c[k] = b[j++];
            } else if (j >= b.length) {
                c[k] = a[i++];
            } else if (a[i] <= b[j]) {
                c[k] = a[i++];
            } else {
                c[k] = b[j++];
            }

        }
        return c;
    }

    public int[] mergesort(int[] input) {
        int N = input.length;
        if (N <= 1) return input;
        int[] a = new int[N / 2];
        int[] b = new int[N - N / 2];
        for (int i = 0; i < a.length; i++)
            a[i] = input[i];
        for (int i = 0; i < b.length; i++)
            b[i] = input[i + N / 2];
//        return merge(mergesort(a), mergesort(b));
        return merge(mergesort(a), mergesort(b));
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
                recoursion++;
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

    private void exchange(int i, int j) {
        int temp = numbers[i];
        numbers[i] = numbers[j];
        numbers[j] = temp;
    }

    public static double mergesort(int[] a, int low, int high) {
        if (low < high) {
            int mid = (low + high) / 2;
            double c1 = mergesort(a, low, mid);
            double c2 = mergesort(a, mid + 1, high);
            double c3 = merge(a, low, mid, high);
            return c1 + c2 + c3;
        }
        return 0;
    }

    private static double merge(int[] a, int low, int mid, int high) {
        double val = 0;
        int[] ret = new int[high - low + 1];
        int left_p = low;
        int right_p = mid + 1;
        int count = 0;
        while (left_p <= mid && right_p <= high) {
            if (a[left_p] <= a[right_p]) {
                ret[count++] = a[left_p++];
            } else {
                int left = mid - left_p + 1;
                val += left;
                ret[count++] = a[right_p++];
            }
        }

        while (right_p <= high) {
            ret[count++] = a[right_p++];
        }
        while (left_p <= mid) {
            ret[count++] = a[left_p++];
        }
        for (int i = low; i <= high; i++) {
            a[i] = ret[i - low];
        }
        return val;
    }
}



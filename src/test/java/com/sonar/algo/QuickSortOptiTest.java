package com.sonar.algo;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.fail;

public class QuickSortOptiTest {

    @Test
    public void simple123Test() {

//        int[] arrayInt = {7, 6, 2, 3, 4, 1, 5, 10, 9, 8};
        int[] arrayInt = {7, 10, 9, 8};
        int[] arrayIntSorted = Arrays.copyOf(arrayInt, arrayInt.length);

        Arrays.sort(arrayIntSorted);
        compare2arrays(arrayIntSorted, QuickSortOpti.sort(arrayInt, 0));
    }

    @Test
    public void simple54321Test() {

        int[] arrayInt = {5, 4, 3, 2, 1};
        int[] arrayIntSorted = Arrays.copyOf(arrayInt, arrayInt.length);

        Arrays.sort(arrayIntSorted);
        compare2arrays(arrayIntSorted, QuickSortOpti.sort(arrayInt, 0));
    }

    @Test
    public void simple12345Test() {

        int[] arrayInt = {1, 2, 3, 4, 5};
        int[] arrayIntSorted = Arrays.copyOf(arrayInt, arrayInt.length);

        Arrays.sort(arrayIntSorted);
        compare2arrays(arrayIntSorted, QuickSortOpti.sort(arrayInt, 0));
    }

    @Test
    public void simpleNullTest() {

        int[] arrayInt = {};
        int[] arrayIntSorted = Arrays.copyOf(arrayInt, arrayInt.length);


        Arrays.sort(arrayIntSorted);
        compare2arrays(arrayIntSorted, QuickSortOpti.sort(arrayInt, 0));
    }


    @Test
    public void simpleAllSameTest() {

        int[] arrayInt = {7, 7, 7, 7};
        int[] arrayIntSorted = Arrays.copyOf(arrayInt, arrayInt.length);


        Arrays.sort(arrayIntSorted);
        compare2arrays(arrayIntSorted, QuickSortOpti.sort(arrayInt, 0));
    }

    @Test
    public void simpleAll2SameTest() {

        int[] arrayInt = {7, 7, 4, 4};
        int[] arrayIntSorted = Arrays.copyOf(arrayInt, arrayInt.length);


        Arrays.sort(arrayIntSorted);
        compare2arrays(arrayIntSorted, QuickSortOpti.sort(arrayInt, 0));
    }

    @Test
    public void simpleAll3SameTest() {

        int[] arrayInt = {4, 4, 4, 7, 7, 7, 4, 4, 4};
        int[] arrayIntSorted = Arrays.copyOf(arrayInt, arrayInt.length);


        Arrays.sort(arrayIntSorted);
        compare2arrays(arrayIntSorted, QuickSortOpti.sort(arrayInt, 0));
    }


    public void compare2arrays(int[] sortedArray, int[] originalArray) {
        for (int i = 0; i < originalArray.length; i++) {
            if (sortedArray[i] != originalArray[i])
                fail("Arrays are not the same!");
        }

    }



}
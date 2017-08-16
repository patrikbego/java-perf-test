package com.sonar.algo;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static java.util.stream.Collectors.joining;
import static org.junit.Assert.fail;

public class NewQuickSortTest {

    @Test
    public void simple123Test() {

        int[] arrayInt = {7, 2, 3, 1, 5};
        int[] arrayIntSorted = Arrays.copyOf(arrayInt, arrayInt.length);

        Arrays.sort(arrayIntSorted);
        compare2arrays(arrayIntSorted, NewQuickSort.sort(arrayInt));
    }

    @Test
    public void simpleNullTest() {

        int[] arrayInt = {};
        int[] arrayIntSorted = Arrays.copyOf(arrayInt, arrayInt.length);


        Arrays.sort(arrayIntSorted);
        compare2arrays(arrayIntSorted, NewQuickSort.sort(arrayInt));
    }


    @Test
    public void simpleAllSameTest() {

        int[] arrayInt = {7, 7, 7, 7};
        int[] arrayIntSorted = Arrays.copyOf(arrayInt, arrayInt.length);


        Arrays.sort(arrayIntSorted);
        compare2arrays(arrayIntSorted, NewQuickSort.sort(arrayInt));
    }

    @Test
    public void simpleAll2SameTest() {

        int[] arrayInt = {7, 7, 4, 4};
        int[] arrayIntSorted = Arrays.copyOf(arrayInt, arrayInt.length);


        Arrays.sort(arrayIntSorted);
        compare2arrays(arrayIntSorted, NewQuickSort.sort(arrayInt));
    }

    @Test
    public void simpleAll3SameTest() {

        int[] arrayInt = {4, 4, 4, 7, 7, 7, 4, 4, 4};
        int[] arrayIntSorted = Arrays.copyOf(arrayInt, arrayInt.length);


        Arrays.sort(arrayIntSorted);
        compare2arrays(arrayIntSorted, NewQuickSort.sort(arrayInt));
    }
 @Test
    public void tersmTest() {

        List<String> terms = Arrays.asList("Vision", "color", "tinged");

        System.out.println(terms.stream().collect(joining(" ")));
    }


    public void compare2arrays(int[] sortedArray, int[] originalArray) {
        for (int i = 0; i < originalArray.length; i++) {
            if (sortedArray[i] != originalArray[i])
                fail("Arrays are not the same!");
        }

    }



}
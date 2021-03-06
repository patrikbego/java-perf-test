package com.sonar.algo;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by begop on 27/07/2017.
 */
public class QuickSortTest1 {
    private int[] numbers;
    private final static int SIZE = 10000;

    @Before
    public void setUp() throws Exception {
        numbers = new int[SIZE];
        Inversor inversor = new Inversor();
        List<Integer> integerList = inversor.reader("QuickSort.txt");
        assertEquals(10000, integerList.size());
        numbers = integerList.stream().mapToInt(i -> i).toArray();
    }

    @Test
    public void testNull() {
        QuickSort sorter = new QuickSort();
        sorter.party(null);
    }

    @Test
    public void testEmpty() {
        QuickSort sorter = new QuickSort();
        sorter.party(new int[0]);
    }

    @Test
    public void testSimpleElement() {
        QuickSort sorter = new QuickSort();
        int[] test = new int[1];
        test[0] = 5;
        sorter.party(test);
    }

    @Test
    public void testSpecial() {
        QuickSort sorter = new QuickSort();
        int[] test = {5, 5, 6, 6, 4, 4, 5, 5, 4, 4, 6, 6, 5, 5};
        sorter.party(test);
        if (!validate(test)) {
            fail("Should not happen");
        }
        printResult(test);
    }

    @Test
    public void testSpecia1() {
        QuickSort sorter = new QuickSort();
//        int[] test = {4, 3, 1, 2};
        int[] test = {5, 5, 6, 6, 4, 4, 5, 5, 4, 4, 6, 6, 5, 5};
        sorter.party(test);

        if (!validate(test)) {
            fail("Should not happen");
            printResult(test);
        }
    }

//    @Test

    public void testQuickSort() {

        long startTime = System.currentTimeMillis();

        QuickSort sorter = new QuickSort();
        sorter.party(numbers);
//        System.out.println("Nr of recursion : " + sorter.getNrOfRecursions());
        long stopTime = System.currentTimeMillis();
        long elapsedTime = stopTime - startTime;
        System.out.println("QuickSort " + elapsedTime);

        if (!validate(numbers)) {
            fail("Should not happen");
        }
        assertTrue(true);
    }

    @Test
    public void testStandardSort() {
        long startTime = System.currentTimeMillis();
        Arrays.sort(numbers);
        long stopTime = System.currentTimeMillis();
        long elapsedTime = stopTime - startTime;
        System.out.println("Standard Java sort " + elapsedTime);
        if (!validate(numbers)) {
            fail("Should not happen");
        }
        assertTrue(true);
    }

    private boolean validate(int[] numbers) {
        for (int i = 0; i < numbers.length - 1; i++) {
            if (numbers[i] > numbers[i + 1]) {
                return false;
            }
        }
        return true;
    }

    private void printResult(int[] numbers) {
        for (int i = 0; i < numbers.length; i++) {
            System.out.print(numbers[i]);
        }
        System.out.println();
    }

}
package com.sonar.algo;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.Calendar;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

/**
 * Created by patrik007 on 16/07/2017.
 */
public class InversorTest {
    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void reader() throws Exception {
        Inversor inversor = new Inversor();
        List<Integer> integerList = inversor.reader("file.txt");
        assertEquals(100000, integerList.size());
    }

    @Test
    public void sorter() throws Exception {
        Inversor inversor = new Inversor();
        List<Integer> integerList = inversor.reader("file.txt");

        long timeInMillis = Calendar.getInstance().getTimeInMillis();
        List<Integer> integerList1 = inversor.sorter(integerList);
        System.out.println("1 : " + (Calendar.getInstance().getTimeInMillis() - timeInMillis));

        timeInMillis = Calendar.getInstance().getTimeInMillis();
        Collections.sort(integerList);
        System.out.println("1 : " + (Calendar.getInstance().getTimeInMillis() - timeInMillis));

        assertEquals(100000, integerList1.size());
        assertEquals(100000, integerList.size());

        assertEquals(java.util.Optional.of(100000).get(), integerList1.get(99999));
        assertEquals(java.util.Optional.of(100000).get(), integerList.get(99999));
    }

    @Test
    public void sorter1() throws Exception {
        Inversor inversor = new Inversor();
        List<Integer> integerList = inversor.reader("file.txt");

        int[] array = integerList.stream().mapToInt(i->i).toArray();
        long timeInMillis = Calendar.getInstance().getTimeInMillis();
        int[] sortedArray = inversor.sorter1(array);
        System.out.println("1 : " + (Calendar.getInstance().getTimeInMillis() - timeInMillis));


        assertEquals(100000, sortedArray.length);
        assertEquals(100000, integerList.size());

        assertEquals(1, sortedArray[0]);
        assertEquals(100000, sortedArray[99999]);
        assertNotEquals(java.util.Optional.of(100000).get(), integerList.get(99999));
    }

    @Test()
    public void mergeAndSort() throws Exception {
        Inversor inversor = new Inversor();
        List<Integer> integerList = inversor.reader("file.txt");

        int[] array = integerList.stream().mapToInt(i->i).toArray();
        long timeInMillis = Calendar.getInstance().getTimeInMillis();
//        inversor.sort(array);
//        inversor.sort(new int[]{3,2,1});
//        inversor.sort(new int[]{1,2,3});
//        inversor.sort(new int[]{5,4,3,2,1});
//        inversor.sort(new int[]{1,3,5,2,4,6});
//        inversor.sort(new int[]{1,3,5,7,9,2,4,6,8,10});
        inversor.sort(new int[]{10,9,8,7,6,5,4,3,2,1});
        System.out.println("1 : " + (Calendar.getInstance().getTimeInMillis() - timeInMillis));

        assertEquals(100000, array.length);
        assertEquals(100000, integerList.size());

        assertEquals(1, array[0]);
        assertEquals(100000, array[99999]);
    }

    @Test
    public void quicksort() throws Exception {
        Inversor inversor = new Inversor();
        List<Integer> integerList = inversor.reader("file.txt");

        int[] array = integerList.stream().mapToInt(i->i).toArray();
        long timeInMillis = Calendar.getInstance().getTimeInMillis();
        inversor.quicksort(array);
        System.out.println("1 : " + (Calendar.getInstance().getTimeInMillis() - timeInMillis));

        assertEquals(100000, array.length);
        assertEquals(100000, integerList.size());

        assertEquals(1, array[0]);
        assertEquals(100000, array[99999]);
    }

}
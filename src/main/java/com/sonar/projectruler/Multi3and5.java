package com.sonar.projectruler;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by begop on 16/06/2017.
 */
public class Multi3and5 {

    public static void main(String[] args) {

        Set<Integer> integerList = new HashSet<>();

        int max = 1000;


        for (int i = 1; i < 1001; i++) {
            if (i * 3 < max)
                integerList.add(i*3);
            if (i * 5 < max)
                integerList.add(i*5);
        }

        int sum = 0;
        for (Integer i : integerList) {
            sum += i;
        }

        System.out.println(sum);
    }

}

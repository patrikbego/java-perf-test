package com.sonar.projectruler;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by begop on 16/06/2017.
 */
public class FIbonacci {

    public static void main(String[] args) {

        /**
         * Each new term in the Fibonacci sequence is generated by adding the previous two terms. By starting with 1 and 2, the first 10 terms will be:
         * 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, ...
         * By considering the terms in the Fibonacci sequence whose values do not exceed four million, find the sum of the even-valued terms.
         * Set<Integer> integerList = new HashSet<>();
         * */


        List<Integer> fibos = new ArrayList();
        for (int i = 1; i <= 4000000; i++) {
            if (i == 1) {
                fibos.add(i);
                fibos.add(i);
            }
            if ((fibos.get(i) + fibos.get(i - 1)) > 4000000) {
                break;
            }
            fibos.add(fibos.get(i) + fibos.get(i - 1));

        }

        final long[] sum = {0};
        fibos.forEach(fibi -> {
            if (fibi % 2 == 0)
                sum[0] += fibi;
        });
        System.out.println(sum[0]);
    }

}

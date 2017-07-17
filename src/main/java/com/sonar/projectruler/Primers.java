package com.sonar.projectruler;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by begop on 16/06/2017.
 */
public class Primers {

    public static void main(String[] args) {

        /**
         * The prime factors of 13195 are 5, 7, 13 and 29.
         * What is the largest prime factor of the number 600851475143 ?
         * */


        List<Long> primeFactors = new ArrayList<>();

        for (long i = 13195; i >= 1; i--) {
            if (isItPrimaryNumber(i)) {
                primeFactors.add(i);
                break;
            }
        }

        primeFactors.forEach(i -> System.out.println(i));
//        System.out.println(sum[0]);
    }


    public static boolean isItPrimaryNumber(Long number) {
        List<Long> dividers = new ArrayList<>();
        if(number % 2 == 0  || number % 3 == 0 || number % 5 == 0 || number % 7 == 0) {
            return false;
        }

        for (long i = 10; i <= number; i++) {
            if (number % i == 0) {
                dividers.add(i);
            }
            if (dividers.size() > 2) {
                return false;
            }
        }
        return dividers.size() == 2 ? true : false;

    }


}

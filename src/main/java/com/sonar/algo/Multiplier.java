package com.sonar.algo;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 * Created by begop on 07/07/2017.
 */
public class Multiplier {


    public static void main(String[] args) {
        long start = Calendar.getInstance().getTimeInMillis();
//        So: what's the product of the following two 64-digit numbers?
//
//        3141592653589793238462643383279502884197169399375105820974944592
//
//        2718281828459045235360287471352662497757247093699959574966967627

//        String stringNr1 = "3141592653589793238462643383279502884197169399375105820974944592";
//        String stringNr2 = "2718281828459045235360287471352662497757247093699959574966967627";
        String stringNr1 = "12";
        String stringNr2 = "12";

        char[] arrayNr1 = stringNr1.toCharArray();
        char[] arrayNr2 = stringNr2.toCharArray();


        List<List<Integer>> resultList = new ArrayList();
        for (int i = arrayNr1.length - 1; i >= 0; i--) {
            List<Integer> integerList = new ArrayList();
            for (int j = 0 ; j <  arrayNr2.length; j++) {
                int tempNumb = 0;
                Integer partRes = Integer.parseInt(String.valueOf(arrayNr1[i]))
                        * Integer.parseInt(String.valueOf(arrayNr2[j]));
                char[] partArray = partRes.toString().toCharArray();
                if (partArray.length != 1) {
                    tempNumb = Integer.parseInt(String.valueOf(partArray[0]));
                }
                if (partArray.length != 1) {
                    integerList.add(Integer.parseInt(String.valueOf(partArray[1])));
                } else {
                    integerList.add(Integer.parseInt(String.valueOf(partArray[0])) + tempNumb);
                }

            }
            resultList.add(integerList);
        }
//        Collections.reverse(integerList);
//        System.out.println(integerList);
        System.out.println("Time needed : " + (Calendar.getInstance().getTimeInMillis() - start));
    }

}

package com.sonar.algo;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.List;

/**
 * Created by begop on 07/07/2017.
 */
public class Multiplier {


    public static void main(String[] args) {
//        So: what's the product of the following two 64-digit numbers?
//
//        3141592653589793238462643383279502884197169399375105820974944592
//
//        2718281828459045235360287471352662497757247093699959574966967627


        String nr1s = "3141592653589793238462643383279502884197169399375105820974944592";
        String nr2s = "2718281828459045235360287471352662497757247093699959574966967627";
        System.out.println( multiply(nr1s, nr2s));

        System.out.println(new BigDecimal("3141592653589793238462643383279502884197169399375105820974944592").multiply(
                        new BigDecimal("2718281828459045235360287471352662497757247093699959574966967627")));



//        assert summer(Integer.toString(1), Integer.toString(10)).contains(Integer.toString(10));

//                        369     891
//                         246     891
        //                 123    9801
//                        39583
        for (int i = 0; i < 1000; i++) {
            for (int j = 0; j < 1000; j++) {
//                System.out.println("i = " + i + " j = " + j + " = " + (i * j));
//                assert multiply(Integer.toString(i), Integer.toString(j)).contains(Integer.toString(i * j));
            }
        }

    }

    private static String summer(String nr1s, String nr2s) {
        long start = Calendar.getInstance().getTimeInMillis();
        char[] nr1a = nr1s.toCharArray();
        char[] nr2a = nr2s.toCharArray();


        List<Integer> finalResult = new ArrayList<>();
        List<List<Integer>> listOfPartilaResults = new ArrayList<>();
        for (int i = nr1a.length - 1; i >= 0; i--) {
            List<Integer> partialResult = new ArrayList<>();
            int carryOver = 0;
            boolean reverse = false;
            for (int j = 0; j < nr2a.length; j++) {

                Integer partProduct = (parseInt(nr1a[i]) * parseInt(nr2a[j])) + carryOver;
                System.out.println("partProduct + " + partProduct);


                if (partProduct > 9) {
                    carryOver = getNrFromPartProd(partProduct, 0);
                    partialResult.add(getNrFromPartProd(partProduct, 1));
                    if (j + 1 == nr2a.length) {
                        partialResult.add(carryOver);
                        reverse = true;
                    }

                } else {
                    carryOver = 0;
                    partialResult.add(getNrFromPartProd(partProduct, 0));

                }

            }
            if (reverse && i ==1)
                Collections.reverse(partialResult);
            listOfPartilaResults.add(sumArrayOfInts(partialResult));
            System.out.println("partialResult " + partialResult);

            for (int d = listOfPartilaResults.size() - 1; d >= 0; d--) {
                Collections.reverse(listOfPartilaResults.get(d));
                listOfPartilaResults.get(d).add(0);
//                System.out.println(listOfPartilaResults.get(d));
                Collections.reverse(listOfPartilaResults.get(d));
                System.out.println(listOfPartilaResults.get(d));
            }

            System.out.println("listOfPartilaResults : " + listOfPartilaResults);
        }


        for (int d = listOfPartilaResults.size() - 1; d >= 0; d--) {
            listOfPartilaResults.get(d).remove(0);
//            Collections.reverse(listOfPartilaResults.get(d));
            System.out.println(listOfPartilaResults.get(d));
        }

        for (int i = listOfPartilaResults.get(0).size() - 1; i >= 0; i--) {

            int fr = 0;
            for (int j = 0; j < listOfPartilaResults.size(); j++) {

                int elementInArray = 0;

                if (listOfPartilaResults.size() - 1 >= j && listOfPartilaResults.get(j).size() - 1 >= i)
                    elementInArray = listOfPartilaResults.get(j).get(i);
                fr += elementInArray;


//                System.out.println(fr);

//                Integer partProduct = (parseInt(nr1a[i]) * parseInt(nr2a[j])) + carryOver;


            }


            finalResult.add(fr);
        }


        Collections.reverse(finalResult);


        System.out.println("final result : " + finalResult);


//        int carryOver = 0;
        List<Integer> reallyFinalResult = sumArrayOfInts(finalResult);
//        for (int i = finalResult.size() -1 ; i >= 0; i--) {
//
//            int currentNumber = finalResult.get(i) + carryOver;
//            if (currentNumber > 9) {
//                carryOver = getNrFromPartProd(currentNumber, 0);
//                if (i + 1 == finalResult.size()) {
//                    reallyFinalResult.add(carryOver);
//                }
//                reallyFinalResult.add(getNrFromPartProd(currentNumber, 1));
//            } else {
//                carryOver = 0;
//                reallyFinalResult.add(currentNumber);
//            }
//        }
        System.out.println("reallyFinalResult before reverse : " + reallyFinalResult.toString().replace(",", "").replace(" ", ""));
        Collections.reverse(reallyFinalResult);
        System.out.println("It took " + (Calendar.getInstance().getTimeInMillis() - start));
        String product = reallyFinalResult.toString().replace(",", "").replace(" ", "");
        System.out.println("Product is " + product);
        return product;
    }

    private static int getNrFromPartProd(Integer partProduct, int pos) {
        char[] intArray = partProduct.toString().toCharArray();

        return parseInt(intArray[pos]);
    }

    private static List<Integer> sumArrayOfInts(List<Integer> finalResult) {
        int carryOver = 0;
        List<Integer> reallyFinalResult = new ArrayList<>();
        boolean reverse = false;
        for (int i = finalResult.size() - 1; i >= 0; i--) {

            int currentNumber = finalResult.get(i) + carryOver;
            if (currentNumber > 9) {
                carryOver = getNrFromPartProd(currentNumber, 0);
                if (i + 1 == finalResult.size()) {
                    reallyFinalResult.add(carryOver);
                }
                reallyFinalResult.add(getNrFromPartProd(currentNumber, 1));
            } else {
                carryOver = 0;
                reallyFinalResult.add(currentNumber);
            }


        }

        return reallyFinalResult;
    }

    static private Integer parseInt(char charInt) {
        try {
            return Integer.parseInt(String.valueOf(charInt));
        } catch (Exception e) {
            System.out.println("Cant parse int");

        }
        return null;
    }




    public static String multiply(String num1, String num2){
        int product, carry=0, sum=0;
        String result = new String("");
        String partial = new String("");
        ArrayList<String> partialList = new ArrayList<String>();

        /* computing partial products using this loop. */
        for(int j=num2.length()-1 ; j>=0 ; j--) {
            for(int i=num1.length()-1 ; i>=0 ; i--) {

                product = Integer.parseInt((new Character(num1.charAt(i))).toString()) *
                        Integer.parseInt((new Character(num2.charAt(j))).toString()) + carry;
                carry = product/10;
                partial = Integer.toString(product%10) + partial;
            }

            if(carry != 0)
                partial = Integer.toString(carry) + partial;

            partialList.add(partial);
            partial = "";
            carry = 0;
        }

        /* appending zeroes incrementally */
        for(int i=0 ; i<partialList.size() ; i++)
            partialList.set(i, partialList.get(i) + (Long.toString( (long)java.lang.Math.pow(10.0,(double)i))).substring(1)   );

        /* getting the size of the largest partial product(last) */
        int largestPartial = partialList.get(partialList.size()-1).length();

        /* prefixing zeroes */
        int zeroes;
        for(int i=0 ; i<partialList.size() ; i++) {
            zeroes =  largestPartial - partialList.get(i).length();

            if(zeroes >= 1)
                partialList.set(i, (Long.toString( (long)java.lang.Math.pow(10.0,(double)zeroes))).substring(1) + partialList.get(i)   );
        }

        /* to compute the result */
        carry = 0;
        for(int i=largestPartial-1 ; i>=0 ; i--) {

            sum = 0;
            for(int j=0 ; j<partialList.size() ; j++)
                sum = sum + Integer.parseInt(new Character(partialList.get(j).charAt(i)).toString());

            sum = sum + carry;
            carry = sum/10;
            result = Integer.toString(sum%10) + result;
        }

        if(carry != 0)
            result = Integer.toString(carry) + result;

        return result;
    }

}

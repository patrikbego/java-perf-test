package com.sonar.algo;

/**
 * Created by begop on 07/07/2017.
 */
public class MultiplierBeta {


//    public static void main(String[] args) {
////        So: what's the product of the following two 64-digit numbers?
////
////        3141592653589793238462643383279502884197169399375105820974944592
////
////        2718281828459045235360287471352662497757247093699959574966967627
//
//
////        String nr1s = "3141592653589793238462643383279502884197169399375105820974944592";
////        String nr1s = "2718281828459045235360287471352662497757247093699959574966967627";
//
//        long start = Calendar.getInstance().getTimeInMillis();
//        String nr1s = "12";
//        String nr2s = "12";
////                        891
////                       891
////                         9801
//        char[] nr1a = nr1s.toCharArray();
//        char[] nr2a = nr2s.toCharArray();
//
//
//        List<Integer> finalResult = new ArrayList<>();
//        List<List<Integer>> listOfPartilaResults = new ArrayList<>();
//        for (int i = nr1a.length - 1; i >= 0; i--) {
//            List<Integer> partialResult = new ArrayList<>();
//            int carryOver = 0;
//            for (int j = 0; j < nr2a.length; j++) {
//
//                Integer partProduct = (parseInt(nr1a[i]) * parseInt(nr2a[j])) + carryOver;
//                if (partProduct > 9) {
//                    carryOver = getNrFromPartProd(partProduct, 0);
//                    partialResult.add(getNrFromPartProd(partProduct, 1));
//                    if (j + 1 == nr2a.length)
//                        partialResult.add(carryOver);
//
//                } else {
//                    carryOver = 0;
//                    partialResult.add(getNrFromPartProd(partProduct, 0));
//
//                }
//
//
//            }
//            listOfPartilaResults.forEach(part -> {
//                Collections.reverse(part);
//                part.add(0);
//                Collections.reverse(part);
//            });
//
//            listOfPartilaResults.add(partialResult);
//
//
//        }
//
//
////        listOfPartilaResults.forEach(j -> {
////            final int[] fr = {0};
////            final int[] carryOver = {0};
////            listOfPartilaResults.forEach(i -> {
////
////                fr[0] += i.get(listOfPartilaResults.indexOf(j)) + carryOver[0];
////
////            });
////            if (fr[0] > 9) {
////                carryOver[0] = getNrFromPartProd(fr[0], 0);
////                finalResult.add(getNrFromPartProd(fr[0], 1));
//////                if (j + 1 == listOfPartilaResults.size())
//////                    finalResult.add(carryOver[0]);
////
////            } else {
////                carryOver[0] = 0;
////                finalResult.add(getNrFromPartProd(fr[0], 0));
////
////            }
////
////            finalResult.add(fr[0]);
////            System.out.println(fr[0]);
////            System.out.println(j.toString());
////        });
//
//        for (int i = 0; i < listOfPartilaResults.get(0).size(); i++) {
//
//            int fr = 0;
//            for (int j = 0; j < listOfPartilaResults.size(); j++) {
//
//                int elementInArray = 0;
//
//                if (listOfPartilaResults.size() -1 >= j && listOfPartilaResults.get(j).size() -1 >= i)
//                    elementInArray = listOfPartilaResults.get(j).get(i);
//                fr += elementInArray;
//                System.out.println(fr);
//
//
//            }
//            finalResult.add(fr);
//        }
//        System.out.println(finalResult);
//        System.out.println("It took " + (Calendar.getInstance().getTimeInMillis() - start));
//        System.out.println("Product is " + finalResult);
//    }
//
//    private static int getNrFromPartProd(Integer partProduct, int pos) {
//        char[] intArray = partProduct.toString().toCharArray();
//
//        return parseInt(intArray[pos]);
//    }
//
//
//    static private Integer parseInt(char charInt) {
//        try {
//            return Integer.parseInt(String.valueOf(charInt));
//        } catch (Exception e) {
//            System.out.println("Cant parse int");
//
//        }
//        return null;
//    }
}

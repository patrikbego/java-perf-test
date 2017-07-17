package com.sonar.algo;

/**
 * Created by begop on 07/07/2017.
 */
public class MultiplierBackup {


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
//
//        List<List<Integer>> listOfPartilaResults = new ArrayList<>();
//        for (int i = nr1a.length - 1; i >= 0; i--) {
//            List<Integer> partialResult = new ArrayList<>();
//            int carryOver = 0;
//            for (int j = 0; j < nr2a.length; j++) {
//
//                Integer partProduct = (parseInt(nr1a[i]) * parseInt(nr2a[j])) + carryOver ;
//                if (partProduct > 9) {
//                    carryOver = getNrFromPartProd(partProduct, 0);
//                    partialResult.add(getNrFromPartProd(partProduct, 1));
//                    if(j + 1 == nr2a.length)
//                        partialResult.add(carryOver);
//                }
//                else {
//                    carryOver = 0;
//                    partialResult.add(getNrFromPartProd(partProduct, 0));
//                }
//
//
//            }
//            Collections.reverse(partialResult);
//            listOfPartilaResults.add(partialResult);
//
//
//
//        }
//        listOfPartilaResults.forEach(i -> System.out.println(i.toString()));
//
//
//
//
//
//
//        System.out.println("It took " + (Calendar.getInstance().getTimeInMillis() - start));
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

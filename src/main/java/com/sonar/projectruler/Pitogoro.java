package com.sonar.projectruler;

/**
 * Created by begop on 16/06/2017.
 */
public class Pitogoro {

    public static void main(String[] args) {

//        double a = 1;
//        double b = 1;
//        double d = 1;
//        double c = 1000;
//
//        for (double i = 1; i < c * 10; i++) {
//            a = i / 10;
//
//            for (double j = 1; j < c * 10; j++) {
//                b = j / 10;
////                if (a == 3 && b == 4)
////                    System.out.print(2);
////                if (i < j && ((a * a) + (b * b) == c)) {
////                    System.out.println("i " + a + " j " + b + " = c");
////                    System.out.println(i * j);
////                }
//
//                for (double k = 1; k < c * 10; k++) {
//                    d = k / 10;
//                    if ((i < j) && (j < k) && ((a * a) + (b * b) == (d * d)) && (a + b + d) == 1000) {
//                        System.out.println("i " + a + " j " + b + " k " + d + " = c");
//                        System.out.println("i " + a + " j " + b + " k " + d + " = c");
//                        if (((a * a) + (b * b) + (d * d)) == c)
//                            System.out.println("result = " + a * b * d);
//                        System.out.println("result = " + a * b * d);
//                    }
//                }
//            }
//        }

//        int a = 1;
//        double b = 1;
//        double d = 1;
//        double c = 1000;

        for (int i = 1; i < 1000; i++) {
            for (int j = 1; j < 1000; j++) {
                for (int k = 1; k < 1000; k++) {

                    if ((i < j) && (j < k) && ((i * i) + (j * j) == (k * k)) && (i + j + k) == 1000) {
                        System.out.println("i " + i + " j " + j + " k " + k + " = c");
                        if (((i * i) + (j * j) + (k * k)) == 1000)
                            System.out.println("result = " + i * j * k);
                        System.out.println("result = " + i * j * k);
                    }
                }
            }
        }


    }

}

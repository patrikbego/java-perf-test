package com.sonar.projectruler;

import org.junit.Test;

/**
 * Created by begop on 18/07/2017.
 */
public class SquarerTest {
    @Test
    public void recursiveCall() throws Exception {

        int doubleMatrix[][] = new int[3][3];


        Squarer.recursiveCall(doubleMatrix);

    }

    @Test
    public void recursiveCall1() throws Exception {

        for (int i = 0; i < 1000; i++) {
            if (Math.random() >= 0.5)
                System.out.println(1);
            else
                System.out.println(0);

        }
    }

}
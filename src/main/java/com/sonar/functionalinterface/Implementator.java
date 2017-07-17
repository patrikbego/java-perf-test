package com.sonar.functionalinterface;

/**
 * Created by begop on 06/02/2017.
 */
public class Implementator implements ComplexFuncInterface {
    @Override
    public void doWork() {
        System.out.println("calling method from interface;");
    }
}

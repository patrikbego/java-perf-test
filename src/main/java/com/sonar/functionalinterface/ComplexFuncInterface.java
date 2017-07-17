package com.sonar.functionalinterface;

/**
 * Created by begop on 06/02/2017.
 */
@FunctionalInterface
public interface ComplexFuncInterface extends SimpleFuncInterface{
    default void doSomeWork(){
        System.out.println("Smth");
    }

    default void doSomeOtherWork(){System.out.println("test");}



}

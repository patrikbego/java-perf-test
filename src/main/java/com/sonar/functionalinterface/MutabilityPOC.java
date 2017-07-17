package com.sonar.functionalinterface;

/**
 * Created by begop on 27/04/2017.
 */
public class MutabilityPOC {

    public static void main(String[] args) {
        Integer i = new Integer(2);
        setToThree(i);
        System.out.println(i);
        setToFour(i);
        System.out.println(i);
        MutableInteger mutableInteger = new MutableInteger(2);
        setToThree1(mutableInteger);
        System.out.println(mutableInteger.toString());
    }

    public static void setToThree(Integer i) {
        i = new Integer(3);
    }

    public static void setToThree1(MutableInteger i) {
        i.setI(3);
    }

    public static void setToFour(Integer i) {
        i = 4;
    }


    public static class MutableInteger {
        private Integer i;

        public MutableInteger(Integer i) {
            setI(i);
        }

        public Integer getI() {
            return i;
        }

        public void setI(Integer i) {
            this.i = i;
        }

        public String toString(){
            return i.toString();
        }
    }

}

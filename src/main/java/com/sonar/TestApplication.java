package com.sonar;

import java.time.*;
import java.util.*;

//@SpringBootApplication
public class TestApplication {

    public static void main(String[] args) {
        ArrayList<Integer> a = new ArrayList<Integer>();
        Scanner s = new Scanner(System.in);
        boolean x = true;
        while (x == true) {
            try {
                System.out.println("Enter the next integer: ");
            /*Autoboxing takes place here. The primitive type "int" taken in from the
            user is converted to an Integer object.*/
                Integer i = s.nextInt();
                a.add(i);
            } catch (InputMismatchException e) {
                System.out.println("You must enter an integer.");
            }

            System.out.println("Would you like to enter another integer? (Y/N): ");
            char y_n = s.next().charAt(0);
            if (y_n == 'Y') {
                x = true;
            } else {
                x = false;
            }
        }
        for (int i = 0; i < a.size(); i++) {
            System.out.println(a.get(i));
        }

        List list1 = Arrays.asList(6, 2, 4);
        Long time = Calendar.getInstance().getTimeInMillis();
        System.out.println(list1.stream().findFirst().get());
        System.out.println(Calendar.getInstance().getTimeInMillis() - time);
        time = Calendar.getInstance().getTimeInMillis();
        System.out.println(list1.get(0));
        System.out.println(Calendar.getInstance().getTimeInMillis() - time);

        time = Calendar.getInstance().getTimeInMillis();
        Collection<String> col = Arrays.asList("3", "2", "1");
        System.out.println(col.stream().findFirst().get());
        System.out.println(Calendar.getInstance().getTimeInMillis() - time);

        time = Calendar.getInstance().getTimeInMillis();
        System.out.println(col.iterator().next());
        System.out.println(Calendar.getInstance().getTimeInMillis() - time);

        Date dt = new Date();
        Instant instant = Instant.ofEpochMilli(dt.getTime());
        LocalDateTime nowLDT = LocalDateTime.ofInstant(instant, ZoneId.systemDefault());

        LocalDateTime ldt = LocalDateTime.now();
        System.out.println(ldt.toLocalTime());

        ZonedDateTime ldtZoned = ldt.atZone(ZoneId.systemDefault());

        ZonedDateTime utcZoned = ldtZoned.withZoneSameInstant(ZoneId.of("UTC"));

        System.out.println(utcZoned.toLocalTime());

        System.out.println(ZonedDateTime.now(ZoneOffset.UTC).toLocalDate());
        System.out.println(LocalDateTime.now());
    }

    private void createNew() {


    }

    private static void createnew() {


    }

    private static void doSomething(int i) {

    }


    public boolean compareTo(Object other) {
        return false;
    }

}

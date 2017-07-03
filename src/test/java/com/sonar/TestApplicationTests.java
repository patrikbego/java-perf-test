package com.sonar;

import org.assertj.core.util.Preconditions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.util.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestApplicationTests {

    @Test
    public void contextLoads() {

        int i = 31;
        doSomething(i = 42);
        assert (i == 31);

        IdentityHashMap identityHashMap = new IdentityHashMap();

        System.out.println((-1 & 5));
    }

    public void doSomething(int i) {
        System.out.println(i);

    }

    @Test
    public void testColl() {
        Collection<Integer> subTasks = new ArrayList<>();
        subTasks.add(4);
        subTasks.add(5);
        subTasks.add(1);
        subTasks.add(2);

        subTasks.forEach(System.out::println);


        System.out.println(LocalDateTime.now());
        System.out.println(OffsetDateTime.now());
        System.out.println(ZonedDateTime.now());
        System.out.println(ZonedDateTime.now(ZoneOffset.UTC).now());
        System.out.println(ZonedDateTime.now(ZoneOffset.systemDefault()).now());
        System.out.println(ZoneOffset.systemDefault());
    }

    @Test
    public void testColl2() {

        List<String> mscs = Arrays.asList(" this ", " is ", " some ", " mock ");


        String noticeMessage = AlertMessage.formatMessage(" 123", mscs.parallelStream().collect(StringBuilder::new,
                (StringBuilder response, String element) -> {
                    response.append(" ").append(element);
                    System.out.println(element.toString());
                    System.out.println(response.append(" ").append(element));
                },
                (response1, response2) -> {
                    System.out.println(response1.toString());
                    System.out.println(response1.append(",").append(response2.toString()));
                    response1.append(",").append(response2.toString());
                })
                .toString(), null, null);
        System.out.println(noticeMessage);
    }

    @Test
    public void testRandom() {

        Long start = Calendar.getInstance().getTimeInMillis();

        getRandomNumber(1, 50);
        System.out.println(Calendar.getInstance().getTimeInMillis() - start);
        System.out.println(getRandomNumber(1, 50));
        start = Calendar.getInstance().getTimeInMillis();
        int rand = (int) (Math.random() * 9 + 3);
        System.out.println(Calendar.getInstance().getTimeInMillis() - start);
        System.out.println(rand);
    }

    @Test
    public void testStringFormat() {

        Long start = Calendar.getInstance().getTimeInMillis();
        String smth = String.format("this is just some mock test |! ");
        System.out.println(Calendar.getInstance().getTimeInMillis() - start);
        System.out.println(smth);
        start = Calendar.getInstance().getTimeInMillis();
        String smth1 = "this is just some mock test |! ";
        System.out.println(Calendar.getInstance().getTimeInMillis() - start);
        System.out.println(smth1);
    }

    @Test
    public void testPassByReference() {

        String smth = "nothing";
        changeSmth(smth);
        System.out.println(smth);

        int asdf = 1;
        changeAsdf(asdf);
        System.out.println(asdf);

        Thread th1 = new Thread();
        th1.run();

        AlertMessage am = new AlertMessage("orig title");
        changeAm(am);
        System.out.println(am.getTitle());

        AlertMessage am1 = new AlertMessage("orig title");
        changeAm1(am1);
        System.out.println(am1.getTitle());

        (new Thread(new ThreadRunner())).start();
        (new Thread(new ThreadRunner())).start();

        String n = null;

//        Timestamp.valueOf(n);

        Preconditions.checkNotNull(n, "This string is null");
    }

    public class ThreadRunner implements Runnable {

        public void run() {
            AlertMessage am1 = new AlertMessage("orig title");
            changeAm1(am1);
            System.out.println(am1.getTitle());

            changeAm1(am1);
        }
    }


    private void changeAm(final AlertMessage am) {
        am.setTitle("new Title");
    }

    private AlertMessage changeAm1(final AlertMessage am) {
        am.setTitle("Value Title");
        return am;
    }


    private void changeSmth(String smth) {
        smth = "somehing";
    }

    private void changeAsdf(int asdf) {
        asdf = 2;
    }


    private Integer getRandomNumber(int min, int max) {
        if (min == max) {
            return min;
        }
        Random generator = new Random();
        return generator.ints(min, max).limit(1).boxed().map(Integer::valueOf).findAny().get();
    }

    private Integer getRandomNumber1(int min, int max) {
        if (min == max) {
            return min;
        }
        Random generator = new Random();
        return generator.ints(min, max).limit(1).boxed().map((Integer i) -> {
            return Integer.valueOf(i);
        }).findAny().get();
    }

    public static class AlertMessage {

        public static String formatMessage(String title, String arg1, String arg2, String arg3) {

            AlertMessage alertFounded = new AlertMessage(title);

            if (alertFounded == null) {
                return "";
            }

            Formatter fmt = new Formatter();
            fmt.format(alertFounded.getMessage(), (arg1 != null) ? arg1 : "", (arg2 != null) ? arg2 : "", (arg3 != null) ? arg3 : "");
            return fmt.out().toString();
        }

        private String title;
        private String message;


        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public AlertMessage(String title) {
            setMessage(title + " message");
            setMessage(title);
        }
    }

}

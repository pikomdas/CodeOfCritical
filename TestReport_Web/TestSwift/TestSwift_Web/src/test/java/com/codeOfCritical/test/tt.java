package com.codeOfCritical.test;

import org.junit.Test;

import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.IntStream;

public class tt {


    @Test
    public void test() throws InterruptedException {
        AtomicReference<String> name = new AtomicReference<>("");
        Runnable r = () -> {
            IntStream.range(1, 20).forEach(x -> {
                synchronized (this) {
                    name.set(String.valueOf(x)+String.valueOf(x));
                    try {
                        wait(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println("");
            });
            System.out.println(name.get());
        };
        Runnable r1 = () -> {
            try {
                synchronized (this) {
                    Thread.sleep(5000);
                    name.get().replace(" ", "#");
                    notify();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(name.get());
        };
        Thread t1 = new Thread(r);
        Thread t2 = new Thread(r1);
        t1.start();
//        t1.join();
        t2.start();
//        t2.`;

        System.out.println("last->+ " + name.get());
    }
}

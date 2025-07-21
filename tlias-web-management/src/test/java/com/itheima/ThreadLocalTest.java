package com.itheima;

public class ThreadLocalTest {
    private static ThreadLocal<String> local = new ThreadLocal<>();

    public static void main(String[] args) {
        local.set("Main Message");

        System.out.println(Thread.currentThread().getName() + " : " + local.get());

        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName() + " : " + local.get());
            }
        }).start();

        local.remove();
    }
}

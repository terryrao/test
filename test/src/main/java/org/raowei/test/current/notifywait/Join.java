package org.raowei.test.current.notifywait;

import java.util.concurrent.TimeUnit;

/**
 */
public class Join {

    public static void main(String[] args) throws InterruptedException {
        Thread previous = Thread.currentThread();
        for (int i = 0; i < 10; i++) {
            Thread thread = new Thread(new Domino(previous), "thread : " + i);
            thread.start();
            previous = thread;
        }
        TimeUnit.SECONDS.sleep(5);

        System.out.println(Thread.currentThread().getName() + " terminate");
    }
    static class Domino implements Runnable {
        private Thread thread;

        public Domino(Thread thread) {
            this.thread = thread;
        }

        @Override
        public void run() {
            try {
                thread.join();
            } catch (InterruptedException ignored) {
            }
            System.out.println(Thread.currentThread().getName() + " terminate. ");
        }
    }
}

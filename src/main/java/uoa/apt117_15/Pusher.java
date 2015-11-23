package uoa.apt117_15;

import java.util.Random;

public class Pusher implements Runnable {
    CustomStack stack;

    public Pusher(CustomStack stack) {
        this.stack = stack;
    }

    public void run() {
        Random random = new Random();
        for (int i = 0; i < 100; i++) {
            int num = random.nextInt(1000);
            stack.push(num);
            System.out.println(String.format("Push\t[%d] \t%d", Thread.currentThread().getId(), num));
        }
        synchronized (this) {
            notify();
        }
    }
}

package uoa.apt117_15;

import java.util.Date;

public class Topper implements Runnable {
    CustomStack stack;

    public Topper(CustomStack stack) {
        this.stack = stack;
    }

    public void run() {
        for (int i = 0; i < 100; i++) {
            if (stack.size() > 0)
                System.out.println("Top\t\t[" + Thread.currentThread().getId() + "]\t" + stack.top());
        }
    }
}

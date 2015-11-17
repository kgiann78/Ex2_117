package uoa.apt117_15;
import java.util.Random;

public class Client implements Runnable {
    CustomStack stack;

    public Client(CustomStack stack) {
        this.stack = stack;
    }

    public void run() {
        for (int i=0; i < 100; i++) {
            stack.push(i);
            System.out.println("[" + Thread.currentThread().getId() + "] " + stack.top());
        }
        System.out.println("[" + Thread.currentThread().getId() + "] finished pushing\n");
        System.out.println("[" + Thread.currentThread().getId() + "] starts poping\n");
        for (int i=0; i < 100; i++) {
            System.out.println("[" + Thread.currentThread().getId() + "] " + stack.top());
            stack.pop();
        }
    }
}

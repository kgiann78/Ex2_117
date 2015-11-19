package uoa.apt117_15;
import java.util.Random;

public class Popper implements Runnable {
    CustomStack stack;

    public Popper(CustomStack stack) {
        this.stack = stack;
    }

    public void run() {
        System.out.println("Pop\t\t[" + Thread.currentThread().getId() + "]\t" + stack.pop());
    }
}

package uoa.apt117_15;

public class Pusher implements Runnable {
    CustomStack stack;

    public Pusher(CustomStack stack) {
        this.stack = stack;
    }

    public void run() {
        stack.push(Integer.parseInt(Thread.currentThread().getName().replaceAll("Thread-", "")));
            System.out.println("Push\t[" + Thread.currentThread().getName().replaceAll("Thread-", "") + "]");
    }
}

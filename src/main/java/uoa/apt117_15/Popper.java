package uoa.apt117_15;

public class Popper implements Runnable {
    CustomStack stack;

    public Popper(CustomStack stack) {
        this.stack = stack;
    }

    public void run() {
        for (int i = 0; i < 100; i++) {
            if (stack.size() > 0)
                System.out.println("Pop\t\t[" + Thread.currentThread().getId() + "]\t" + stack.pop() + "\tStack size " + stack.size());
        }
        synchronized (this) {
            notify();
        }
    }
}

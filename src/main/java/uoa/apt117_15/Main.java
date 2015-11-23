package uoa.apt117_15;

public class Main {
    public static CustomStack stack = new CustomStack();

    public static void main(String[] args) {
        Pusher pusher = new Pusher(stack);
        Popper popper = new Popper(stack);
        Topper topper = new Topper(stack);
        for (int i = 0; i < 10; i++) {

            Thread threadPusher = new Thread(pusher);
            threadPusher.start();
            Thread threadTopper = new Thread(topper);
            threadTopper.start();

        }

        // While the three different types of instances (pusher, popper and topper)
        // can be in one loop mingling with each other, I select to separate them in
        // different loops to ensure first that the stack is filled up with data.
        // After that I let poppers to draw every element of the stack leaving
        // an empty stack in the end.

        synchronized (pusher) {
            try {
                while (stack.size() < 1000)
                    pusher.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        for (int i = 0; i < 10; i++) {
            Thread threadTopper = new Thread(topper);
            threadTopper.start();
            Thread threadPopper = new Thread(popper);
            threadPopper.start();
        }

        synchronized (popper) {
            try {
                while (stack.size() > 0) {
                    popper.wait();
                }

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

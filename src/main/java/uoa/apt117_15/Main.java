package uoa.apt117_15;

public class Main {
    public static CustomStack stack = new CustomStack();
    public static CustomStack stack2 = new CustomStack();
    public static CustomStack stack3 = new CustomStack();

    public static void main(String[] args) {

        CustomStack stack1 = new CustomStack();
        CustomStack stack2 = new CustomStack();
        CustomStack stack3 = new CustomStack();
        for (int i= 0; i < 3; i++) {
            CustomStackThread threadA = new CustomStackThread(stack1);
            CustomStackThread threadB = new CustomStackThread(stack2);
            CustomStackThread threadC = new CustomStackThread(stack3);
            threadA.start();
            threadB.start();
            threadC.start();
        }

        /*
        Pusher pusher = new Pusher(stack);
        Pusher pusher2 = new Pusher(stack2);
        Pusher pusher3 = new Pusher(stack3);
        Popper popper = new Popper(stack);
        Topper topper = new Topper(stack);
        for (int i = 0; i < 1; i++) {

            Thread threadPusher = new Thread(pusher);
            Thread threadPusher2 = new Thread(pusher2);
            Thread threadPusher3 = new Thread(pusher3);
            threadPusher.start();
            threadPusher2.start();
            threadPusher3.start();
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
        }*/
    }
}

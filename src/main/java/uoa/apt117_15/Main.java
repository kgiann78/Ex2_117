package uoa.apt117_15;

public class Main {
    public static CustomStack stack = new CustomStack();

    public static void main(String[] args) {

        Pusher pusher = new Pusher(stack);
        Popper popper = new Popper(stack);
        Topper topper = new Topper(stack);

        for (int i = 0; i < 10; i++) {
            Thread threadPusher = new Thread(pusher);
            Thread threadPopper = new Thread(popper);
            Thread threadTopper = new Thread(topper);
            threadPusher.start();
            threadTopper.start();
            threadPopper.start();
        }
    }
}

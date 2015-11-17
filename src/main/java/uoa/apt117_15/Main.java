package uoa.apt117_15;

public class Main {
    public static CustomStack stack = new CustomStack();

    public static void main(String[] args) {
        Client client = new Client(stack);

        for (int i = 0; i < 2; i++) {
            Thread thread = new Thread(client);
            thread.start();
        }
    }
}

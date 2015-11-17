package uoa.apt117_15;

public class Main {
    public static CustomStack stack = new CustomStack();

    public static void main(String[] args) {

        Client client = new Client(stack);


        for (int i = 0; i < 2; i++) {
            Thread thread = new Thread(client);
            thread.start();
        }

//        int length = stack.size();
//        System.out.println("Length before poping " + length);
//        for (int i=0; i < length; i++) {
//            System.out.println(stack.pop());
//            System.out.println(stack.top());
//        }
//
//        System.out.println("Length after poping " + stack.size());
//
//        System.out.println(stack.top());
    }
}

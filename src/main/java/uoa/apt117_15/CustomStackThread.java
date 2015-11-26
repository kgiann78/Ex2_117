package uoa.apt117_15;

import java.util.Random;

public class CustomStackThread extends Thread {
    private CustomStack stack;

    CustomStackThread(CustomStack stack) {
        this.stack = stack;
    }

    public void run() {
        for (int i=0; i < 100 ; i++) {
            Random random = new Random();
            int operation = random.nextInt(3);
            if (operation == 0) {
                int val = random.nextInt(999);
                stack.push(val);
                System.out.println(val + " pushed in stack ");
            } else if (operation == 1 && stack.size() != 0)
                System.out.println("Stack.pop:  " + stack.pop() + " ");
            else if (operation == 2 && stack.size() != 0)
                System.out.println("Stack.top:  " + stack.top() + " ");

        }
    }
}

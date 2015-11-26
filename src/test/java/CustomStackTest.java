import org.junit.Test;
import static org.junit.Assert.assertEquals;
import uoa.apt117_15.CustomStack;

public class CustomStackTest {

    @Test
    public void pushTest(){
        CustomStack stack1 = new CustomStack();
        CustomStack stack2 = new CustomStack();
        stack1.push(1);
        stack2.push(1);
        stack1.push(2);
        stack2.push(2);
        stack1.push(3);
        stack2.push(3);

        assertEquals(stack1.size(), 3);
        assertEquals(stack2.size(), 3);
        assertEquals(stack1.top(), 3);
        assertEquals(stack2.top(), 3);
    }

    @Test
    public void popTest(){
        CustomStack stack = new CustomStack();
        stack.push(1);

        assertEquals(stack.size(), 1);
        assertEquals(stack.pop(), 1);
        assertEquals(stack.size(), 0);
    }

    @Test
    public void topTest(){
        CustomStack stack = new CustomStack();
        stack.push(1);

        assertEquals(stack.size(), 1);
        assertEquals(stack.top(), 1);
        assertEquals(stack.size(), 1);
    }
}

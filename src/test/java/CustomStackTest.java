import org.junit.Test;
import static org.junit.Assert.assertEquals;
import uoa.apt117_15.CustomStack;

public class CustomStackTest {

    @Test
    public void pushTest(){
        CustomStack stack = new CustomStack();
        stack.push(1);
        stack.push(2);
        stack.push(3);

        assertEquals(stack.size(), 3);
        assertEquals(stack.top(), 3);
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

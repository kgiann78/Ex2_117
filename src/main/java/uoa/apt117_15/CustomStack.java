package uoa.apt117_15;

public class CustomStack {
    private int size;
    CustomStackElement currentElement = null;

    public CustomStack() {
        size = 0;
    }

    public int size() {
        return size;
    }

    public void push(int element) {
        currentElement = new CustomStackElement(element, currentElement);
        ++size;
    }

    public int pop() {
        if (currentElement != null && size > 0) {
            int value = currentElement.value;
            currentElement = currentElement.previous;
            --size;
            return value;
        } else
            return -1;
    }

    public int top() {
        if (currentElement != null && size > 0)
            return currentElement.value;
        else
            return -1;
    }

    @Override
    public String toString() {
        return "{" +
                currentElement +
                '}';
    }
}

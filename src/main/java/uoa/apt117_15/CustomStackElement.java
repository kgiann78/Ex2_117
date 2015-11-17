package uoa.apt117_15;

public class CustomStackElement {
    int value;
    CustomStackElement previous;

    public CustomStackElement(int value, CustomStackElement previous) {
        this.value = value;
        this.previous = previous;
    }

    @Override
    public String toString() {
        return "" + value + " <- " + this.previous;
    }
}

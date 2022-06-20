package stack;

import java.util.ArrayList;
import java.util.List;

public class ArrayStack {

    private int top;
    private List<Object> stackArray;

    public ArrayStack() {
        this.stackArray = new ArrayList<>();
        this.top = -1;
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public void push(Object item) {
        stackArray.add(item);
        top++;
    }

    public Object peek() {
        if (this.isEmpty()) {
            throw new ArrayIndexOutOfBoundsException();
        }

        return stackArray.get(top);
    }

    public Object pop() {
        Object item = this.peek();
        stackArray.remove(top--);
        return item;
    }

    public static void main(String[] args) {
        ArrayStack arrayStack = new ArrayStack();

        System.out.println(arrayStack.isEmpty());
        arrayStack.push(10);
        System.out.println(arrayStack.peek());
        arrayStack.push(20);
        System.out.println(arrayStack.peek());
        arrayStack.push(30);
        System.out.println(arrayStack.peek());
        arrayStack.pop();
        System.out.println(arrayStack.peek());
    }
}

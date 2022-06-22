package stack;

import java.util.EmptyStackException;

public class MyStack<T> {

    private class StackNode {

        private final T data;
        private StackNode next;

        public StackNode(T data) {
            this.data = data;
        }
    }

    private StackNode top;

    public T pop() {
        if (top == null) {
            throw new EmptyStackException();
        }

        T item = top.data;
        top = top.next;
        return item;
    }

    public void push(T item) {
        StackNode t = new StackNode(item);
        t.next = top;
        top = t;
    }

    public T peek() {
        if (top == null) {
            throw new EmptyStackException();
        }

        return top.data;
    }

    public boolean isEmpty() {
        return top == null;
    }

    public static void main(String[] args) {
        MyStack<Integer> stk = new MyStack<>();
        stk.push(10);
        System.out.println(stk.peek());
        stk.push(20);
        System.out.println(stk.peek());

        System.out.println(stk.isEmpty());
        System.out.println(stk.pop());
        System.out.println(stk.pop());
    }
}
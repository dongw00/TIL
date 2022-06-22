package queue;

import java.util.Stack;

public class MyQueue2<T> {

    private final Stack<T> stkNew, stkOld;

    public MyQueue2() {
        this.stkNew = new Stack<>();
        this.stkOld = new Stack<>();
    }

    public void add(T data) {
        stkNew.push(data);
    }

    private void shiftStacks() {
        if (stkOld.isEmpty()) {
            while (!stkNew.isEmpty()) {
                stkOld.push(stkNew.pop());
            }
        }
    }

    public T remove() {
        shiftStacks();
        return stkOld.pop();
    }

    public T peek() {
        shiftStacks();
        return stkOld.peek();
    }

    public int size() {
        return stkOld.size() + stkNew.size();
    }

}

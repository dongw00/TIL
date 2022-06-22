package queue;

import java.util.NoSuchElementException;

public class MyQueue<T> {

    private class QueueNode {

        private final T data;
        private QueueNode next;

        public QueueNode(T data) {
            this.data = data;
        }
    }

    private QueueNode first;
    private QueueNode last;

    public void add(T item) {
        QueueNode t = new QueueNode(item);
        if (last != null) {
            last.next = t;
        }
        last = t;

        if (first == null) {
            first = t;
        }
    }

    public T remove() {
        if (first == null) {
            throw new NoSuchElementException();
        }

        T data = first.data;
        first = first.next;
        if (first == null) {
            last = null;
        }
        return data;
    }

    public T peek() {
        if (first == null) {
            throw new NoSuchElementException();
        }
        return first.data;
    }

    public boolean isEmpty() {
        return first == null;
    }

    public static void main(String[] args) {
        MyQueue<Integer> queue = new MyQueue<>();

        System.out.println(queue.isEmpty());

        queue.add(10);
        System.out.println(queue.peek());

        queue.add(20);
        System.out.println(queue.peek());

        queue.add(30);
        System.out.println(queue.peek());

        System.out.println(queue.remove());
        System.out.println(queue.remove());
        System.out.println(queue.remove());

        System.out.println(queue.isEmpty());
    }
}

package queue;

import linkedList.Node;

/**
 * CircularQueue
 */

public class CircularQueue {

    private Node head, tail;
    private int count;
    private int capacity;

    public CircularQueue(int k) {
        this.capacity = k;
    }

    public boolean enQueue(int value) {
        if (this.isFull()) {
            return false;
        }

        Node newNode = new Node(value);
        if (this.isEmpty()) {
            head = tail = newNode;
        } else {
            tail.nextNode = newNode;
            tail = newNode;
        }
        this.count += 1;
        return true;
    }

    public boolean deQueue() {
        if (this.isEmpty()) {
            return false;
        }
        this.head = this.head.nextNode;
        this.count -= 1;
        return true;
    }

    public int Front() {
        if (this.isEmpty()) {
            return -1;
        } else {
            return this.head.value;
        }
    }

    public int Rear() {
        if (this.isEmpty()) {
            return -1;
        } else {
            return this.tail.value;
        }
    }

    public boolean isEmpty() {
        return this.count == 0;
    }

    public boolean isFull() {
        return this.count == this.capacity;
    }

    public static void main(String[] args) {
        CircularQueue queue = new CircularQueue(5);
        queue.enQueue(1);
        queue.enQueue(2);
        queue.enQueue(3);
        queue.enQueue(4);
        queue.enQueue(5);
        queue.enQueue(6);
    }
}
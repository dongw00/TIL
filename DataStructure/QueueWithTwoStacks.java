import java.util.NoSuchElementException;

public class QueueWithTwoStacks {
  private Stack stack1;
  private Stack stack2;

  public QueueWithTwoStacks() {
    stack1 = new Stack();
    stack2 = new Stack();
  }

  public static void main(String[] args) {
    QueueWithTwoStacks queue = new QueueWithTwoStacks();
    queue.enQueue(1);
    queue.enQueue(2);
    queue.enQueue(3);
    queue.enQueue(4);
    System.out.println("dequeue : " + queue.deQueue());
    System.out.println("peek : " + queue.peek());
    System.out.println("dequeue : " + queue.deQueue());
  }

  private void moveStack1ToStack2() {
    while (!stack1.isEmpty())
      stack2.push(stack1.pop());
  }

  public boolean isEmpty() {
    return stack1.isEmpty() && stack2.isEmpty();
  }

  public int size() {
    return stack1.size() + stack2.size();
  }

  public int peek() {
    if (isEmpty())
      throw new NoSuchElementException("Queue underflow");
    if (stack2.isEmpty())
      moveStack1ToStack2();
    return stack2.peek();
  }

  public void enQueue(int data) {
    stack1.push(data);
  }

  public int deQueue() {
    if (isEmpty())
      throw new NoSuchElementException("Queue underflow");
    if (stack2.isEmpty())
      moveStack1ToStack2();
    return stack2.pop();
  }
}
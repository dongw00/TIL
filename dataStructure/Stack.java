public class Stack {
  public static void main(String[] args) {
    Stack nums = new Stack();

    nums.push(1);
    nums.push(2);
    nums.push(3);
    nums.push(4);
    nums.push(5);

    System.out.println("size = " + nums.size());
    System.out.println("pop = " + nums.pop());
    System.out.println("pop = " + nums.pop());
    System.out.println("size = " + nums.size());

    System.out.println("peak = " + nums.peek());

    nums.show();
  }

  int stack[] = new int[5];
  int top = 0;

  public void push(int data) {
    if (top == 4)
      System.out.println("Stack is Full!");
    stack[top++] = data;
  }

  public int pop() {
    int data = 0;

    if (isEmpty())
      System.out.println("Stack is Empty");
    else {
      data = stack[--top];
      stack[top] = 0;
    }
    return data;
  }

  public int peek() {
    int data;
    data = stack[top - 1];
    return data;
  }

  public int size() {
    return top;
  }

  public boolean isEmpty() {
    return top <= 0;
  }

  public void show() {
    for (int n : stack) {
      System.out.print(n + " ");
    }
  }
}

package queue;

public class Queue {
	int queue[] = new int[5];
	int size;
	int front;
	int rear;
	
	public void enQueue(int data) {
		queue[rear++] = data;
		size++;
	}
	
	public void deQueue() {
		
	}
	
	public void show() {
		System.out.print("Element : ");
		for (int i=0; i < size; i++)
			System.out.print(queue[i] + " ");
	}
}

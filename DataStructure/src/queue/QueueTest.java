package queue;

public class QueueTest {
	public static void main(String[] args) {
		Queue q = new Queue();
		q.enQueue(5);
		q.enQueue(2);
		
		q.show();
	}
}

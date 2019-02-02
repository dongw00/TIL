package List;

public class LinkedList {
	public class Node {
		private Node next;
		private int data;
		
		public Node getNext() {
			return next;
		}
		
		public void setNext(Node next) {
			this.next = next;
		}
		
		public int getData() {
			return data;
		}
		
		public void setData(int data) {
			this.data = data;
		}
	}
	
	private Node head;
	private int size;
	
	public LinkedList() {
		head = null;
		size = 0;
	}
	
	/* 특정 Index에 새로운 노드를 추가 */
	public void add(int index, Node newNode) {
		Node nextNode = null;
		if (index == 0) {
			if (this.head == null) {
				this.head = new Node();
				this.head.setNext(newNode);
			} else {
				nextNode = this.head.getNext();
				newNode.setNext(nextNode);
				this.head.setNext(newNode);
			}
		} else {
			if (index < 0 || index > this.size - 1) { throw new IndexOutOfBoundsException(); }
			Node previous = this.head;
			
			for (int i=0; i < index - 1; i++) {
				previous = previous.getNext();
				
				if (index < this.size) 
					nextNode = previous.getNext();
				if (nextNode != null) 
					newNode.setNext(nextNode);
				previous.setNext(newNode);
			}
			this.size++;
		}
	}
	
	/* 마지막 부분에 새로운 노드를 추가 */
	public void add(Node newNode) {
		if (this.head == null) {
			this.head = new Node();
			this.head.setNext(newNode);
		} else {
			Node previous = this.head;
			for (int i=0; i < this.size; i++) 
				previous = previous.getNext();
			previous.setNext(newNode);
		}
	}
}

package bp;

import java.util.LinkedList;
import java.util.Scanner;

public class Beak1966 {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);

		int num = sc.nextInt();

		while (num-- > 0) {
			LinkedList<Node> queue = new LinkedList<Node>();
			int n = sc.nextInt();
			int m = sc.nextInt();

			for (int i = 0; i < n; i++)
				queue.addLast(new Node(i, sc.nextInt()));

			int count = 0;
			while (!queue.isEmpty()) {
				Node node = queue.poll();

				boolean check = true;
				for (Node i : queue)
					if (node.priorirty < i.priorirty)
						check = false;
				if (check) {
					count++;
					if (node.index == m)
						break;
				} else {
					queue.addLast(node);
				}
			}
			System.out.println(count);
		}
		sc.close();
	}

	private static class Node {
		int index;
		int priorirty;

		public Node(int index, int priority) {
			this.index = index;
			this.priorirty = priority;
		}
	}
}

import java.util.LinkedList;
import java.util.Scanner;

public class Beak1021 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int M = sc.nextInt();
		LinkedList<Integer> list = new LinkedList<Integer>();

		for (int i = 0; i < N; i++) {
			list.add(i + 1);
		}

		int count = 0;
		for (int i = 0; i < M; i++) {
			int input = sc.nextInt();
			while (true) {
				if (list.get(0) == input) {
					list.removeFirst();
					break;
				}
				count++;
				if (list.indexOf(input) > list.size() / 2) {
					list.addFirst(list.pollLast());
				} else {
					list.addLast(list.pollFirst());
				}
			}
		}
		System.out.println(count);
		sc.close();
	}
}

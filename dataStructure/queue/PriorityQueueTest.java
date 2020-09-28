package queue;

import java.util.*;

import java.io.*;

public class PriorityQueueTest {
	static class Prisoner implements Comparable<Prisoner> {
		String name;
		int sentence;

		public Prisoner(String name, int sentence) {
			super();
			this.name = name;
			this.sentence = sentence;
		}

		@Override
		public int compareTo(Prisoner o) {
			if (this.sentence > o.sentence)
				return 1;
			else if (this.sentence < o.sentence)
				return -1;
			return 0;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PriorityQueue<Prisoner> queue = new PriorityQueue<Prisoner>();

		for (int i = 0; i < 3; i++) {
			String name = br.readLine();
			int sentence = Integer.parseInt(br.readLine());
			queue.add(new Prisoner(name, sentence));
		}

		while (!queue.isEmpty()) {
			Prisoner p = queue.remove();
			System.out.println("Name = " + p.name + ", sentence = " + p.sentence);
		}
	}
}

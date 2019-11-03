package sorting;

import java.io.*;
import java.util.*;

public class Beak10814 {
	static class Pair implements Comparable<Pair> {
		int age;
		String name;

		Pair(int age, String name) {
			this.age = age;
			this.name = name;
		}

		@Override
		public int compareTo(Pair o) {
			if (this.age < o.age)
				return -1;
			else if (this.age == o.age)
				return 0;
			else
				return 1;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		Pair[] arr = new Pair[n];

		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			int age = Integer.parseInt(st.nextToken());
			String name = st.nextToken();

			arr[i] = new Pair(age, name);
		}

		Arrays.sort(arr);

		for (Pair p : arr)
			System.out.print(p.age + " " + p.name + "\n");
	}
}

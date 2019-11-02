package bruteForce;

import java.util.*;
import java.io.*;

public class Beak7568 {
	static class Person {
		int weight, height;

		Person(int weight, int height) {
			this.weight = weight;
			this.height = height;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());

		Person arr[] = new Person[n];
		int rank[] = new int[n];

		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			arr[i] = new Person(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (arr[i].weight > arr[j].weight && arr[i].height > arr[j].height)
					rank[j]++;
			}
		}

		for (int p : rank)
			System.out.print(p + 1 + " ");
	}
}

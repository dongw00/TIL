package greedy;

import java.io.*;
import java.util.*;

public class Beak1700 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());

		int arr[] = new int[k];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < k; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		int count = 0;

		HashSet<Integer> set = new HashSet<>();
		for (int i = 0; i < k; i++) {
			int temp = arr[i];

			if (set.contains(temp))
				continue;

			if (set.size() == n) {
				int idx = -3;
				int target = 0;
				for (int s : set) {
					int tIdx = 9999;
					for (int j = i + 1; j < k; j++) {
						if (s == arr[j]) {
							tIdx = j;
							break;
						}
					}
					if (tIdx == 9999) {
						target = s;
						break;
					} else {
						if (tIdx > idx) {
							idx = tIdx;
							target = arr[tIdx];
						}
					}
				}
				set.remove(target);
				count++;
			}

			set.add(temp);
		}

		System.out.println(count);
	}
}

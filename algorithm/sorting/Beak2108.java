package sorting;

import java.io.*;
import java.util.*;

public class Beak2108 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		int arr[] = new int[n];
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();

		int sum = 0;
		for (int i = 0; i < n; i++) {
			sum += arr[i] = Integer.parseInt(br.readLine());

			if (map.get(arr[i]) == null)
				map.put(arr[i], 1);
			else
				map.put(arr[i], map.get(arr[i]) + 1);
		}

		Arrays.sort(arr);

		List<Map.Entry<Integer, Integer>> list = new LinkedList<>(map.entrySet());

		Collections.sort(list, new Comparator<Map.Entry<Integer, Integer>>() {
			public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
				return (o1.getValue()).compareTo(o2.getValue());
			}
		});

		TreeMap<Integer, Integer> treeMap = new TreeMap<>();

		int MAX = list.get(list.size() - 1).getValue();
		treeMap.put(list.get(list.size() - 1).getKey(), MAX);
		for (int i = 0; i < list.size() - 1; i++) {
			if (MAX == list.get(i).getValue())
				treeMap.put(list.get(i).getKey(), list.get(i).getValue());
		}

		Iterator<Integer> it = treeMap.keySet().iterator();
		int mode = it.next();
		if (it.hasNext())
			mode = it.next();

		// 산술평균
		System.out.println(Math.round(sum / (double)n));
		// 중앙값
		System.out.println(arr[n / 2]);
		// 최빈값
		System.out.println(mode);
		// 차이
		System.out.println(arr[n - 1] - arr[0]);
	}
}

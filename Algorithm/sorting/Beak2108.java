package sorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.TreeMap;

import com.sun.tools.javac.util.List;

public class Beak2108 {
	static int MAX = 0;
	static int MIN = Integer.MAX_VALUE;
	static int MAX_COUNT = 0;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());

		LinkedHashMap<Integer, Integer> map = new LinkedHashMap<Integer, Integer>();

		double sum = 0;
		for (int i = 0; i < n; i++) {
			int key = Integer.parseInt(br.readLine());
			if (!map.containsKey(key))
				map.put(key, 0);
			else
				map.put(key, map.get(key) + 1);
			sum += key;
		}

		TreeMap<Integer, Integer> treeMap = new TreeMap<Integer, Integer>(map);

		int mid = map.size() / 2;

		System.out.println(Math.round(sum / n));
		System.out.println(map.get));
		if (MAX_COUNT % 2 == 0)
			System.out.println(-MAX_COUNT);
		else
			System.out.println(MAX_COUNT);
		System.out.println(arr[n - 1] - arr[0]);
	}
}

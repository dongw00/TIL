package searching;

import java.util.Scanner;

public class Beak2805 {
	static int MAX = 0;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int m = sc.nextInt();
		
		int[] arr = new int[n];
		
		for (int i = 0 ; i< n; i++) {
			arr[i] = sc.nextInt();
			if (MAX < arr[i])
				MAX = arr[i];
		}
			
		int start = 0;
		int last = MAX;
		
		while (start + 1 < last) {
			int mid = (start + last) / 2;
			long sum = 0;
			for (int i = 0; i < n; i++) {
				if (arr[i] > mid)
					sum += arr[i] - mid;
			}
			if (sum >= m)
				start = mid;
			else
				last = mid;
		}
		
		System.out.println(start);
		
		sc.close();
	}
}

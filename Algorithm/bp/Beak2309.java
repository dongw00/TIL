package bp;

import java.util.Arrays;
import java.util.Scanner;

public class Beak2309 {
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);

		int n = 9;
		int[] dwarf = new int[n];
		int sum = 0;
		for (int i = 0; i < n; i++) {
			dwarf[i] = sc.nextInt();
			sum += dwarf[i];
		}
		
		sc.close();
		
		Arrays.sort(dwarf);
		for (int i = 0; i < n; i++) {
			for (int j = i + 1; j < n; j++) {
				if (sum - dwarf[i] - dwarf[j] == 100) {
					for (int k = 0; k < n; k++) {
						if (i == k || j == k)
							continue;
						System.out.println(dwarf[k]);
					}
					System.exit(0);
				}
			}
		}
	}
}

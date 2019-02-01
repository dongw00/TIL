import java.util.Scanner;

public class Beak2908 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str1 = sc.next();
		String str2 = sc.next();

		int[] arr1 = new int[3];
		int[] arr2 = new int[3];

		for (int i = 0; i < 3; i++) {
			arr1[i] = str1.charAt(2 - i) - 48;
			arr2[i] = str2.charAt(2 - i) - 48;
		}

		for (int i = 0; i < 3; i++) {
			if (arr1[i] > arr2[i]) {
				for (int j = 0; j < 3; j++)
					System.out.print(arr1[j]);
				break;
			} else if (arr1[i] == arr2[i]) {
				continue;
			} else {
				for (int j = 0; j < 3; j++)
					System.out.print(arr2[j]);
				break;
			}
		}
		sc.close();
	}
}

import java.util.Scanner;

public class Beak1874 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		int num = sc.nextInt();
		int max = 0;
		int top = 0;
		int stack[] = new int[num];

		while (num-- > 0) {
			int temp = sc.nextInt();
			if (temp > max) {
				for (int i = max + 1; i <= temp; i++) {
					stack[top++] = i;
					sb.append("+\n");
				}
				max = temp;
			} else if (stack[top - 1] != temp) {
				System.out.print("NO");
				return;
			}
			top--;
			sb.append("-\n");
		}
		System.out.print(sb);
		sc.close();
	}
}

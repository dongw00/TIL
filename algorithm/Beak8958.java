import java.util.Scanner;

public class Beak8958 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int num = sc.nextInt();
		
		
		String[] str = new String[num+1];

		for (int i = 0; i < num; i++) {
			int count = 0, sum = 0;
			str[i] = sc.next();
			for (int j =0; j < str[i].length(); j++) {
				if (str[i].charAt(j) == 'O')
					sum += ++count;
				else count = 0;
			}
			System.out.println(sum);
		}
		
		sc.close();
	}
}

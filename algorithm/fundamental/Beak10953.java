package fundamental;
import java.io.IOException;
import java.util.Scanner;

public class Beak10953 {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		while (T-- > 0) {
			String[] arr = sc.next().split(",");
			System.out.println(Integer.parseInt(arr[0]) + Integer.parseInt(arr[1]));
		}
		sc.close();
	}
}

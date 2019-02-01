import java.util.Scanner;
import java.util.Stack;

public class Beak10799 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		String str = sc.nextLine();

		Stack<Character> st = new Stack<Character>();
		int result = 0;
		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) == ')') {
				st.pop();
				result += st.size();
			} else {
				st.push(str.charAt(i));
			}
		}
		System.out.println(result);

		sc.close();
	}
}

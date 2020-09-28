package stack;

import java.util.Scanner;
import java.util.Stack;

public class Beak9012 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int t = sc.nextInt();
		sc.nextLine();
		while (t > 0) {
			Stack<Character> stack = new Stack<Character>();
			String str = sc.nextLine();
			for (int i = 0; i < str.length(); i++) {
				if (!stack.isEmpty() && str.charAt(i) == ')' && stack.peek() == '(')
					stack.pop();
				else
					stack.push(str.charAt(i));
			}
			if (stack.isEmpty())
				System.out.println("YES");
			else
				System.out.println("NO");
			t--;
		}
		
		
		sc.close();
	}
}

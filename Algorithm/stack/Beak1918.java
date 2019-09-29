package stack;

import java.util.*;
import java.io.*;

public class Beak1918 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();

		Stack<Character> stk = new Stack<>();

		for (int i = 0; i < str.length(); i++) {
			int p = priority(str.charAt(i));

			switch (str.charAt(i)) {
			case '+':
			case '-':
			case '*':
			case '/':
				while (!stk.isEmpty() && priority(stk.peek()) >= p) {
					System.out.print(stk.pop());
				}
				stk.push(str.charAt(i));
				break;
			case '(':
				stk.push(str.charAt(i));
				break;
			case ')':
				while (!stk.isEmpty() && stk.peek() != '(') {
					System.out.print(stk.pop());
				}
				stk.pop();
				break;
			default:
				System.out.print(str.charAt(i));
			}
		}
		while (!stk.isEmpty()) {
			System.out.print(stk.pop());
		}
	}

	private static int priority(char c) {
		switch (c) {
		case '(':
		case ')':
			return 0;
		case '+':
		case '-':
			return 1;
		case '*':
		case '/':
			return 2;
		}
		return -1;
	}

}

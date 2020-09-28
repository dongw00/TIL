package stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.awt.Point;

public class Beak2493 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		String[] input = br.readLine().split(" ");
		Stack<Point> stack = new Stack<Point>();

		for (int i = 1; i <= n; i++) {
			int value = Integer.parseInt(input[i - 1]);

			while (!stack.isEmpty()) {
				if (value < stack.peek().x) {
					System.out.print(stack.peek().y + " ");
					break;
				}
				stack.pop();
			}

			if (stack.empty())
				System.out.print(0 + " ");
			stack.push(new Point(value, i));
		}
		System.out.println();
	}
}

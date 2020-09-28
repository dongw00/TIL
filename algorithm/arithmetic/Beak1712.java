package arithmetic;

import java.io.*;
import java.util.*;

public class Beak1712 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());

		int res = 0;

		if (b >= c)
			res = -1;
		else
			res = a / (c - b) + 1;

		System.out.println(res);
	}
}

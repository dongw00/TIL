package easyProblem;

import java.io.*;
import java.util.*;

public class Beak2884 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int h = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		if (m < 45) {
			h--;
			m += 60;
			if (h < 0)
				h = 23;
		}

		System.out.print(h + " " + (m - 45));
	}
}

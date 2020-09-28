package arithmetic;

import java.io.*;
import java.util.*;

public class Beak10250 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int t = Integer.parseInt(br.readLine());

		while (t-- > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int h = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			int n = Integer.parseInt(st.nextToken());

			int line = n / h + 1;
			int story = n % h;

			if (story == 0) {
				line = n / h;
				story = h;
			}

			System.out.println(story * 100 + line);
		}
	}

}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Beak4811 {
	public static long[][] map;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n;
		
		while((n = Integer.parseInt(br.readLine())) != 0) {
			map = new long[2*n+1][2*n+1];
			int w = n-1;
			int h = 1;
			System.out.println(pill(w,h));
		}
	}
	
	private static long pill(int w, int h) {
		if (w > 0) {
			if (map[w][h] != 0)
				return map[w][h];
		}
		if (w == 0) {
			map[w][h] = 1;
			return 1;
		} else {
			long sum = 0;
			sum += pill(w-1, h+1);
			if (h >= 1)
				sum += pill(w, h-1);
			map[w][h] = sum;
			return sum;
		}
	}
}
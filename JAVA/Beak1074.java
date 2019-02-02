import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Beak1074 {
	private static int N;
	private static int R,C,cnt = 0;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		z((int)Math.pow(2,N), 0, 0);
	}
	
	public static void z(int n, int r, int c) {
		if (n == 2) {
			if (r == R && c == C) {
				System.out.println(cnt++);
				return;
			}
			cnt++;
			if (r == R && c+1 == C) {
				System.out.println(cnt++);
				return;
			}
			cnt++;
			if (r+1 == R && c == C) {
				System.out.println(cnt++);
				return;
			}
			cnt++;
			if (r+1 == R && c+1 == C) {
				System.out.println(cnt++);
				return;
			}
			cnt++;
			return;
		}
		z(n/2, r, c);
		z(n/2, r, c + n/2);
		z(n/2, r + n/2, c);
		z(n/2, r + n/2, c + n/2);
	}
}

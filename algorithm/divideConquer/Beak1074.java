package divideConquer;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Beak1074 {

    static int ans;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        solve((int) Math.pow(2, n), r, c);
        System.out.println(ans);
    }

    public static void solve(int n, int r, int c) {
        if (n == 1) {
            return;
        }

        if (r < n / 2 && c < n / 2) {
            solve(n / 2, r, c);
        } else if (r < n / 2 && c >= n / 2) {
            ans += n * n / 4;
            solve(n / 2, r, c - n / 2);
        } else if (r >= n / 2 && c < n / 2) {
            ans += (n * n / 4) * 2;
            solve(n / 2, r - n / 2, c);
        } else {
            ans += (n * n / 4) * 3;
            solve(n / 2, r - n / 2, c - n / 2);
        }
    }
}

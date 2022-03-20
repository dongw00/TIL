package dp;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Beak11050 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        System.out.println(comb(n, k));
    }

    public static int comb(int n, int k) {
        if (n == k || k == 0) {
            return 1;
        }

        return comb(n - 1, k - 1) + comb(n - 1, k);
    }
}

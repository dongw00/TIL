package arithmetic;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Beak10986 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int sum = 0;
        int[] cnt = new int[m];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            sum = (sum + Integer.parseInt(st.nextToken())) % m;
            cnt[sum]++;
        }

        long ans = cnt[0];
        for (int i = 0; i < m; i++) {
            ans += (long) cnt[i] * (cnt[i] - 1) / 2;
        }
        System.out.println(ans);
    }
}

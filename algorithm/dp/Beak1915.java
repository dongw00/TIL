package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Beak1915 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] arr = new int[n][m];

        for (int i = 0; i < n; i++) {
            String[] str = br.readLine().split("");
            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(str[j]);
            }
        }

        if (n < 2 || m < 2) {
            System.out.println(1);
            System.exit(0);
        }

        int ans = 0;
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                if (arr[i][j] == 1) {
                    arr[i][j] =
                        Math.min(arr[i - 1][j], Math.min(arr[i][j - 1], arr[i - 1][j - 1])) + 1;
                    ans = Math.max(ans, arr[i][j]);
                }
            }
        }

        System.out.println(ans * ans);
    }
}

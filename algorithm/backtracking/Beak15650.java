package backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Beak15650 {
    static int n, m;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        int[] arr = new int[n + 1];
        boolean[] check = new boolean[n + 1];

        dfs(arr, check, 0);
    }

    public static void dfs(int[] arr, boolean[] check, int cnt) {
        if (cnt == m) {
            if (isOrdered(arr)) {
                for (int i = 0; i < m; i++) {
                    System.out.print(arr[i] + " ");
                }
                System.out.println();
            }
        }

        for (int i = 1; i <= n; i++) {
            if (!check[i]) {
                check[i] = true;
                arr[cnt] = i;
                dfs(arr, check, cnt + 1);
                check[i] = false;
            }
        }
    }

    public static boolean isOrdered(int[] arr) {
        for (int i = 1; i < m; i++) {
            if (arr[i - 1] > arr[i])
                return false;
        }
        return true;
    }
}

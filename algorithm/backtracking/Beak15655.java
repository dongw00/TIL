package backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Beak15655 {

    static int n, m;
    static int[] arr;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        int[] ans = new int[m];
        visited = new boolean[n];
        backTracking(0, ans);
    }

    public static void backTracking(int cnt, int[] ans) {
        if (cnt == m) {
            if (!isOrdered(ans)) {
                return;
            }

            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < ans.length; i++) {
                sb.append(ans[i]);

                if (i != ans.length - 1) {
                    sb.append(" ");
                }
            }
            System.out.println(sb);
            return;
        }

        for (int i = 0; i < arr.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                ans[cnt] = arr[i];
                backTracking(cnt + 1, ans);
                visited[i] = false;
            }
        }
    }

    public static boolean isOrdered(int[] ans) {
        for (int i = 0; i < ans.length - 1; i++) {
            if (ans[i] >= ans[i + 1]) {
                return false;
            }
        }

        return true;
    }
}

package backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Beak15650 {

    private static int n, m;
    private static boolean[] visited = new boolean[9];
    private static int[] arr = new int[9];

    private static void dfs(int cnt) {
        if (cnt == m) {
            if (isOrderByAsc()) {
                for (int i = 0; i < m; i++) {
                    System.out.print(arr[i] + " ");
                }
                System.out.println();
            }
        }

        for (int i = 1; i <= n; i++) {
            if (!visited[i]) {
                visited[i] = true;
                arr[cnt] = i;
                dfs(cnt + 1);
                visited[i] = false;
            }
        }
    }

    private static boolean isOrderByAsc() {
        if (m == 1) {
            return true;
        }

        for (int i = 1; i < m; i++) {
            if (arr[i - 1] > arr[i]) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        dfs(0);
    }
}
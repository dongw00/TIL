package graph.dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Beak2606 {
    static int n, cnt = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        int[][] arr = new int[n + 1][n + 1];
        boolean[] visited = new boolean[n + 1];

        for (int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            arr[a][b] = 1;
            arr[b][a] = 1;
        }

        dfs(arr, visited, 1);
        System.out.println(cnt - 1);
    }

    private static void dfs(int[][] arr, boolean[] visited, int idx) {
        if (visited[idx]) {
            return;
        }

        visited[idx] = true;
        cnt++;

        for (int i = 0; i < arr[idx].length; i++) {
            if (arr[idx][i] == 1 && !visited[i]) {
                dfs(arr, visited, i);
            }
        }
    }
}

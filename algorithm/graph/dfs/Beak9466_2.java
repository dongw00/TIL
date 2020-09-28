package graph.dfs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Beak9466_2 {

    private static int[] arr;
    private static boolean[] visited, finished;
    private static int cnt;

    private static void dfs(int v) {
        visited[v] = true;
        int next = arr[v];

        if (visited[next]) {
            if (!finished[next]) {
                for (int i = next; i != v; i = arr[i]) {
                    cnt++;
                }
                cnt++;
            }
        } else {
            dfs(next);
        }
        finished[v] = true;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());

            arr = new int[n];
            visited = new boolean[n];
            finished = new boolean[n];

            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(st.nextToken()) - 1;
            }

            cnt = 0;
            for (int i = 0; i < n; i++) {
                if (!visited[i]) {
                    dfs(i);
                }
            }

            System.out.println(n - cnt);
        }
    }
}
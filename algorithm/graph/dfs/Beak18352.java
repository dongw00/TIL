package graph.dfs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Beak18352 {

    static List<Integer>[] list;
    static int[] visited;
    static int x, k;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());

        list = new ArrayList[n + 1];
        visited = new int[n + 1];

        Arrays.fill(visited, Integer.MAX_VALUE);

        for (int i = 1; i <= n; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            list[start].add(end);
        }

        dfs(x, 0);

        List<Integer> ans = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            if (visited[i] == k) {
                ans.add(i);
            }
        }

        if (ans.size() == 0) {
            System.out.println(-1);
        } else {
            for (int el : ans) {
                System.out.println(el);
            }
        }
    }

    private static void dfs(int idx, int depth) {
        if (visited[idx] <= depth || depth > k) {
            return;
        }

        visited[idx] = depth;

        for (int el : list[idx]) {
            if (visited[el] > depth + 1 || depth + 1 <= k) {
                dfs(el, depth + 1);
            }
        }
    }
}

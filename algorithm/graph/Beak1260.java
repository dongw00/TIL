package graph;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Beak1260 {

    static List<Integer>[] list;
    static boolean[] visited;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int v = Integer.parseInt(st.nextToken());

        list = new ArrayList[n + 1];

        for (int i = 1; i <= n; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            list[a].add(b);
            list[b].add(a);
        }

        visited = new boolean[n + 1];
        dfs(v);
        System.out.println();
        Arrays.fill(visited, false);
        bfs(v);
        System.out.println();
    }

    private static void dfs(int idx) {
        System.out.print(idx + " ");
        visited[idx] = true;

        for (int el : list[idx]) {
            if (!visited[el]) {
                dfs(el);
            }
        }
    }

    private static void bfs(int start) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        visited[start] = true;

        while (!queue.isEmpty()) {
            int num = queue.remove();
            System.out.print(num + " ");

            for (int el : list[num]) {
                if (!visited[el]) {
                    queue.add(el);
                    visited[el] = true;
                }
            }
        }
    }
}

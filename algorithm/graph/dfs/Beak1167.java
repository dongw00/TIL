package graph.dfs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Beak1167 {

    static int v;
    static List<Pair>[] list;
    static boolean[] visited;
    static int max, maxIdx;

    static class Pair {

        int to, cost;

        Pair(int to, int cost) {
            this.to = to;
            this.cost = cost;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        v = Integer.parseInt(br.readLine());

        list = new ArrayList[v + 1];
        visited = new boolean[v + 1];

        for (int i = 1; i <= v; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < v; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            while (true) {
                int to = Integer.parseInt(st.nextToken());
                if (to == -1) {
                    break;
                }

                int cost = Integer.parseInt(st.nextToken());
                list[from].add(new Pair(to, cost));
            }
        }

        dfs(1, 0);

        max = 0;
        visited = new boolean[v + 1];
        dfs(maxIdx, 0);

        System.out.println(max);
    }

    private static void dfs(int idx, int cost) {
        if (visited[idx]) {
            return;
        }

        if (max < cost) {
            max = cost;
            maxIdx = idx;
        }
        visited[idx] = true;

        for (Pair el : list[idx]) {
            dfs(el.to, el.cost + cost);
        }
    }
}

package graph.dfs;

import java.util.ArrayList;
import java.util.List;

public class Pro43162 {

    static List<Integer>[] list;
    static boolean[] visited;

    public static void main(String[] args) {
        System.out.println(solution(3, new int[][]{{1, 1, 0}, {1, 1, 0}, {0, 0, 1}}));
        System.out.println(solution(3, new int[][]{{1, 1, 0}, {1, 1, 1}, {0, 1, 1}}));
    }

    public static int solution(int n, int[][] computers) {
        int ans = 0;
        list = new ArrayList[n];
        visited = new boolean[n];

        for (int i = 0; i < n; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j || computers[i][j] == 0) {
                    continue;
                }

                list[i].add(j);
                list[j].add(i);
            }
        }

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                ans++;
                dfs(i);
            }
        }
        return ans;
    }

    public static void dfs(int idx) {
        visited[idx] = true;

        for (int i = 0; i < list[idx].size(); i++) {
            int next = list[idx].get(i);
            if (!visited[next]) {
                dfs(next);
            }
        }
    }
}

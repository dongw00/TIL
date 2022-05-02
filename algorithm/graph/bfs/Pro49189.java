package graph.bfs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Pro49189 {

    public static void main(String[] args) {
        Pro49189 p = new Pro49189();
        System.out.println(p.solution(6, new int[][]{{3, 6}, {4, 3}, {3, 2}, {1, 3}, {1, 2}, {2, 4}, {5, 2}}));
    }

    class Pair {
        int depth;
        int num;

        Pair(int num, int depth) {
            this.num = num;
            this.depth = depth;
        }
    }

    public int solution(int n, int[][] edge) {
        List<Integer>[] list = new ArrayList[n + 1];
        boolean[] visited = new boolean[n + 1];

        int[] depth = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            list[i] = new ArrayList<>();
            depth[i] = Integer.MAX_VALUE;
        }

        for (int[] el : edge) {
            int a = el[0];
            int b = el[1];

            list[a].add(b);
            list[b].add(a);
        }

        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(1, 0));
        visited[1] = true;

        int max = 0;
        while (!queue.isEmpty()) {
            Pair p = queue.remove();
            depth[p.num] = Math.min(depth[p.num], p.depth);
            max = Math.max(depth[p.num], max);

            for (int el : list[p.num]) {
                if (!visited[el]) {
                    queue.add(new Pair(el, p.depth + 1));
                    visited[el] = true;
                }
            }
        }

        int ans = 0;
        for (int el : depth) {
            if (el == max) {
                ans++;
            }
        }

        return ans;
    }
}

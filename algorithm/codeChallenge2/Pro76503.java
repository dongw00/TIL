package codeChallenge2;

import java.util.ArrayList;
import java.util.List;

public class Pro76503 {

    static long ans;
    static boolean[] visited;
    static long[] tmp;
    static List<Integer>[] child;

    public static void main(String[] args) {
        System.out.println(solution(new int[]{-5, 0, 2, 1, 2}, new int[][]{{0, 1}, {3, 4}, {2, 3}, {0, 3}}));
        System.out.println(solution(new int[]{0, 1, 0}, new int[][]{{0, 1}, {1, 2}}));
    }

    public static long solution(int[] a, int[][] edges) {
        int size = a.length;
        ans = 0;
        visited = new boolean[size];
        child = new ArrayList[size];
        tmp = new long[size];

        long sum = 0;

        for (int i = 0; i < size; i++) {
            sum += a[i];
            child[i] = new ArrayList<>();
            tmp[i] = a[i];
        }

        if (sum != 0) {
            return -1;
        }

        for (int[] edge : edges) {
            child[edge[0]].add(edge[1]);
            child[edge[1]].add(edge[0]);
        }

        dfs(0);
        return ans;
    }

    public static long dfs(int idx) {
        visited[idx] = true;

        for (int i = 0; i < child[idx].size(); i++) {
            int next = child[idx].get(i);
            if (!visited[next]) {
                tmp[idx] += dfs(next);
            }
        }

        ans += Math.abs(tmp[idx]);
        return tmp[idx];
    }
}

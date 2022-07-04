package graph.MST;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Beak1414 {

    static PriorityQueue<Edge> edges;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        edges = new PriorityQueue<>(Comparator.comparingInt(o -> o.w));

        int total = 0;
        for (int i = 0; i < n; i++) {
            char[] chars = br.readLine().toCharArray();

            for (int j = 0; j < n; j++) {
                int num = getCharNum(chars[j]);
                total += num;

                if (i == j || num == 0) {
                    continue;
                }

                edges.add(new Edge(i, j, num));
            }
        }

        int[] parent = new int[n];
        for (int i = 1; i < n; i++) {
            parent[i] = i;
        }

        int cnt = 0, edgeCnt = 0;
        while (!edges.isEmpty()) {
            Edge edge = edges.remove();

            if (getParent(parent, edge.start) != getParent(parent, edge.end)) {
                unionParent(parent, edge.start, edge.end);
                cnt += edge.w;
                edgeCnt++;
            }
        }

        if (n - 1 != edgeCnt) {
            System.out.println(-1);
            return;
        }
        System.out.println(total - cnt);
    }

    public static int getParent(int[] parent, int x) {
        if (parent[x] == x) {
            return x;
        }

        return parent[x] = getParent(parent, parent[x]);
    }

    public static void unionParent(int[] parent, int a, int b) {
        a = getParent(parent, a);
        b = getParent(parent, b);

        if (a < b) {
            parent[b] = a;
        } else {
            parent[a] = b;
        }
    }

    public static int getCharNum(char c) {
        if ('a' <= c && c <= 'z') {
            return c - 'a' + 1;
        } else if ('A' <= c && c <= 'Z') {
            return c - 'A' + 27;
        } else {
            return 0;
        }
    }

    static class Edge {

        int start, end, w;

        Edge(int start, int end, int w) {
            this.start = start;
            this.end = end;
            this.w = w;
        }
    }

}

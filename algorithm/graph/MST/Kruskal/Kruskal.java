package graph.MST.Kruskal;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Kruskal {

    static class Edge {
        int start, end, distance;

        Edge(int start, int end, int distance) {
            this.start = start;
            this.end = end;
            this.distance = distance;
        }
    }

    private static int getParent(int[] parent, int x) {
        if (parent[x] == x)
            return x;

        return parent[x] = getParent(parent, parent[x]);
    }

    private static void unionParent(int[] parent, int a, int b) {
        a = getParent(parent, a);
        b = getParent(parent, b);

        if (a < b) {
            parent[b] = a;
        } else {
            parent[a] = b;
        }
    }

    private static boolean find(int[] parent, int a, int b) {
        a = getParent(parent, a);
        b = getParent(parent, b);

        return a == b;
    }

    public static void main(String[] args) {
        List<Edge> list = new ArrayList<>();
        list.add(new Edge(1, 7, 12));
        list.add(new Edge(1, 4, 28));
        list.add(new Edge(1, 2, 67));
        list.add(new Edge(1, 5, 17));
        list.add(new Edge(2, 4, 24));
        list.add(new Edge(2, 5, 62));
        list.add(new Edge(3, 5, 20));
        list.add(new Edge(3, 6, 37));
        list.add(new Edge(4, 7, 13));
        list.add(new Edge(5, 6, 45));
        list.add(new Edge(5, 7, 73));

        list.sort(Comparator.comparingInt(a -> a.distance));

        int[] parent = new int[8];
        for (int i = 1; i < parent.length; i++) {
            parent[i] = i;
        }

        int sum = 0;
        for (Edge edge : list) {
            if (!find(parent, edge.start, edge.end)) {
                sum += edge.distance;
                unionParent(parent, edge.start, edge.end);
            }
        }

        System.out.println(sum);
    }

}

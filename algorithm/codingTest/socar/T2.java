package codingTest.socar;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class T2 {

    static final int INF = 10000001;

    static List<Route>[] list;
    static int[] cost;
    static int[] mile;

    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(5, 4,
            new int[][]{{1, 5, 1, 1}, {1, 2, 4, 3}, {1, 3, 3, 2}, {2, 5, 2, 1}, {2, 4, 2, 3},
                {3, 4, 2, 2}})));
    }

    public static int[] solution(int n, int k, int[][] paths) {
        list = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            list[i] = new ArrayList<>();
        }

        for (int[] path : paths) {
            int a = path[0];
            int b = path[1];
            int c = path[2];
            int d = path[3];

            list[a].add(new Route(b, c, d));
            list[b].add(new Route(a, c, d));
        }

        cost = new int[n + 1];
        mile = new int[n + 1];
        Arrays.fill(cost, INF);

        dijkstra(1, n);

        return new int[]{cost[k], mile[k]};
    }

    public static void dijkstra(int start, int n) {
        PriorityQueue<Route> pq = new PriorityQueue<>(((o1, o2) -> {
            if (o1.time == o2.time) {
                return -Integer.compare(o1.mileage, o2.mileage);
            }
            return Integer.compare(o1.time, o2.time);
        }));

        boolean[] visited = new boolean[n + 1];
        pq.add(new Route(start, 0, 0));
        cost[start] = 0;

        while (!pq.isEmpty()) {
            Route r = pq.remove();

            if (visited[r.end]) {
                continue;
            }

            visited[r.end] = true;

            for (Route el : list[r.end]) {
                if (cost[el.end] > cost[r.end] + el.time) {
                    cost[el.end] = cost[r.end] + el.time;
                    mile[el.end] = mile[r.end] + el.mileage;
                    pq.add(new Route(el.end, cost[el.end], mile[el.end]));
                } else if (cost[el.end] == cost[r.end] + el.time) {
                    mile[el.end] = Math.max(mile[r.end] + el.mileage, mile[el.end]);
                }
            }
        }
    }

    static class Route {

        int end, time, mileage;

        Route(int end, int time, int mileage) {
            this.end = end;
            this.time = time;
            this.mileage = mileage;
        }
    }
}

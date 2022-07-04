package graph.MST;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Beak17472 {

    static int[][] arr;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static int n, m;
    static PriorityQueue<Edge> edges;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[n][m];
        edges = new PriorityQueue<>(Comparator.comparingInt(o -> o.len));

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 섬 분류
        int idx = 2;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (arr[i][j] == 1) {
                    bfs(i, j, idx++);
                }
            }
        }

        // 간선 생성
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (arr[i][j] > 1) {
                    connect(i, j);
                }
            }
        }

        // Union-find
        int[] parent = new int[idx + 1];
        for (int i = 2; i <= idx; i++) {
            parent[i] = i;
        }

        int ans = 0, edgeCnt = 2;
        while (!edges.isEmpty()) {
            Edge edge = edges.remove();

            if (getParent(parent, edge.start) != getParent(parent, edge.end)) {
                unionParent(parent, edge.start, edge.end);
                ans += edge.len;
                edgeCnt++;
            }
        }

        if (edgeCnt != idx - 1) {
            System.out.println(-1);
        } else {
            System.out.println(ans);
        }
    }

    private static void bfs(int x, int y, int idx) {
        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(x, y));
        arr[x][y] = idx;

        while (!queue.isEmpty()) {
            Pair p = queue.remove();

            for (int i = 0; i < 4; i++) {
                int nx = p.x + dx[i];
                int ny = p.y + dy[i];

                if (0 <= nx && nx < n && 0 <= ny && ny < m) {
                    if (arr[nx][ny] == 1) {
                        queue.add(new Pair(nx, ny));
                        arr[nx][ny] = idx;
                    }
                }
            }
        }
    }

    private static void connect(int x, int y) {
        int curIdx = arr[x][y];

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            int len = 0;

            if (0 > nx || nx >= n || 0 > ny || ny >= m || arr[nx][ny] != 0) {
                continue;
            }

            while (0 <= nx && nx < n && 0 <= ny && ny < m) {
                if (arr[nx][ny] == curIdx) {
                    break;
                } else if (arr[nx][ny] != 0) {
                    if (len > 1) {
                        edges.add(new Edge(curIdx, arr[nx][ny], len));
                    }
                    break;
                }
                len++;

                if (dx[i] == 1) {
                    nx++;
                } else if (dy[i] == 1) {
                    ny++;
                } else if (dx[i] == -1) {
                    nx--;
                } else {
                    ny--;
                }
            }
        }
    }

    private static int getParent(int[] arr, int x) {
        if (arr[x] == x) {
            return x;
        }

        return arr[x] = getParent(arr, arr[x]);
    }

    private static void unionParent(int[] arr, int a, int b) {
        a = getParent(arr, a);
        b = getParent(arr, b);

        if (a < b) {
            arr[b] = a;
        } else {
            arr[a] = b;
        }
    }

    static class Edge {

        int start, end, len;

        Edge(int start, int end, int len) {
            this.start = start;
            this.end = end;
            this.len = len;
        }
    }

    static class Pair {

        int x, y;

        Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}

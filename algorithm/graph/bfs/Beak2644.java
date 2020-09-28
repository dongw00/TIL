package graph.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Beak2644 {

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int from = Integer.parseInt(st.nextToken());
        int to = Integer.parseInt(st.nextToken());

        int m = Integer.parseInt(br.readLine());

        int[][] arr = new int[n + 1][n + 1];
        int[] depth = new int[n + 1];
        boolean[] visited = new boolean[n + 1];

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            arr[x][y] = 1;
            arr[y][x] = 1;
        }

        if (from == to) {
            System.out.println(0);
            System.exit(0);
        }

        Queue<Integer> queue = new LinkedList<>();
        queue.add(from);
        visited[from] = true;
        while (!queue.isEmpty()) {
            int cur = queue.remove();

            for (int i = 1; i <= n; i++) {
                if (arr[cur][i] == 1 && !visited[i]) {
                    visited[i] = true;
                    queue.add(i);
                    depth[i] = depth[cur] + 1;
                }
            }
        }

        System.out.println(depth[to] == 0 ? -1 : depth[to]);
    }
}
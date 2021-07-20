package graph.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Beak2606 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        int[][] arr = new int[n + 1][n + 1];
        boolean[] visited = new boolean[n + 1];

        for (int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            arr[a][b] = 1;
            arr[b][a] = 1;
        }

        Queue<Integer> queue = new LinkedList<>();
        visited[1] = true;
        queue.add(1);

        int cnt = 0;

        while (!queue.isEmpty()) {
            int val = queue.remove();

            for (int i = 1; i <= n; i++) {
                if (arr[val][i] == 1 && !visited[i]) {
                    queue.add(i);
                    visited[i] = true;
                    cnt++;
                }
            }
        }

        System.out.println(cnt);
    }
}

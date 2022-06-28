package graph.dfs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Beak13023 {

    static List<Integer>[] list;
    static boolean[] visited;
    static boolean arrive;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        list = new ArrayList[n];
        visited = new boolean[n];

        for (int i = 0; i < n; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            list[a].add(b);
            list[b].add(a);
        }

        for (int i = 0; i < n; i++) {
            dfs(i, 1);
            if (arrive) {
                break;
            }
        }

        System.out.println(arrive ? "1" : "0");
    }

    private static void dfs(int idx, int depth) {
        if (depth == 5 || arrive) {
            arrive = true;
            return;
        }

        visited[idx] = true;
        for (int el : list[idx]) {
            if (!visited[el]) {
                dfs(el, depth + 1);
            }
        }
        visited[idx] = false;
    }

}

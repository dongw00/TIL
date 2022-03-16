package samsung;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Beak15686 {

    static int m, ans = Integer.MAX_VALUE;

    static boolean[] visited;
    static int[] chickenIdx;
    static List<Pair> home, chicken, tmp;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        home = new ArrayList<>();
        chicken = new ArrayList<>();
        tmp = new ArrayList<>();
        chickenIdx = new int[m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                int el = Integer.parseInt(st.nextToken());
                if (el == 1) {
                    home.add(new Pair(i, j));
                } else if (el == 2) {
                    chicken.add(new Pair(i, j));
                }
            }
        }

        visited = new boolean[chicken.size()];

        dfs(0, 0);
        System.out.println(ans);
    }

    public static void dfs(int idx, int cnt) {
        if (cnt == m) {
            int sum = 0;
            for (Pair h : home) {
                int min = Integer.MAX_VALUE;

                for (Pair c : tmp) {
                    int diff = Math.abs(h.x - c.x) + Math.abs(h.y - c.y);
                    min = Math.min(min, diff);
                }
                sum += min;
            }

            ans = Math.min(sum, ans);
            return;
        }

        for (int i = idx; i < chicken.size(); i++) {
            if (!visited[i]) {
                visited[i] = true;
                tmp.add(chicken.get(i));
                dfs(i + 1, cnt + 1);
                tmp.remove(tmp.size() - 1);
                visited[i] = false;
            }
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

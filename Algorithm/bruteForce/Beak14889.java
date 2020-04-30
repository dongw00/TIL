package bruteForce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Beak14889 {

    static int n;
    static int[][] arr;
    static boolean[] visited;

    static int ans = Integer.MAX_VALUE;

    private static void dfs(int cur, int cnt) {
        List<Integer> teamStart = new ArrayList<>();
        List<Integer> teamLink = new ArrayList<>();

        if (cnt == n / 2) {
            for (int i = 0; i < n; i++) {
                if (visited[i]) {
                    teamStart.add(i);
                } else {
                    teamLink.add(i);
                }
            }

            int statStart = 0, statLink = 0;

            for (int i = 0; i < teamStart.size(); i++) {
                for (int j = i + 1; j < teamStart.size(); j++) {
                    statStart += arr[teamStart.get(i)][teamStart.get(j)] + arr[teamStart.get(j)][teamStart.get(i)];
                    statLink += arr[teamLink.get(i)][teamLink.get(j)] + arr[teamLink.get(j)][teamLink.get(i)];
                }
            }

            ans = Math.min(ans, Math.abs(statStart - statLink));
            return;
        }

        for (int i = cur + 1; i < n; i++) {
            if (!visited[i]) {
                visited[i] = true;
                dfs(i, cnt + 1);
                visited[i] = false;
            }
        }
    }

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        arr = new int[n][n];
        visited = new boolean[n];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(0, 0);

        System.out.println(ans);
    }

}
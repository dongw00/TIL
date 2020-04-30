package graph.dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Beak1182 {

    private static int n, s, cnt, curSum;
    private static int[] arr;

    private static void dfs(int v) {
        if (v == n) {
            return;
        }

        if (curSum + arr[v] == s) {
            cnt++;
        }

        // left
        dfs(v + 1);

        // right
        curSum += arr[v];
        dfs(v + 1);

        curSum -= arr[v];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        s = Integer.parseInt(st.nextToken());

        arr = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        dfs(0);
        System.out.println(cnt);
    }
}
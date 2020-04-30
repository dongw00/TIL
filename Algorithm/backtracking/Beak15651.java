package backtracking;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Beak15651 {

    static int n, m;
    static int arr[] = new int[8];
    static boolean visited[] = new boolean[8];

    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    private static void dfs(int cnt) throws IOException {
        if (cnt == m) {
            for (int i = 0; i < m; i++) {
                bw.write(arr[i] + " ");
            }
            bw.newLine();
        }

        for (int i = 1; i <= n; i++) {
            if (cnt == m) {
                return;
            }
            arr[cnt] = i;
            dfs(cnt + 1);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        dfs(0);
        bw.flush();
    }
}
package backtracking;

import java.io.*;
import java.util.StringTokenizer;

public class Beak15652 {
    static int n, m;
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        int[] arr = new int[n + 1];
        dfs(arr, 0);
        bw.flush();
    }

    public static void dfs(int[] arr, int cnt) throws IOException {
        if (cnt == m) {
            if (isOrdered(arr)) {
                for (int i = 0; i < m; i++) {
                    bw.write(arr[i] + " ");
                }
                bw.newLine();
            }
            return;
        }

        for (int i = 1; i <= n; i++) {
            arr[cnt] = i;
            dfs(arr, cnt + 1);
        }
    }

    public static boolean isOrdered(int[] arr) {
        for (int i = 1; i < m; i++) {
            if (arr[i - 1] > arr[i])
                return false;
        }

        return true;
    }
}

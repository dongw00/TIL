package backtracking;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Beak15654 {
    static int n, m;
    static int[] arr;
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[n];
        int[] tmp = new int[n];
        boolean[] check = new boolean[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        dfs(tmp, check, 0);
        bw.flush();
    }

    public static void dfs(int[] tmp, boolean[] check, int cnt) throws IOException {
        if (cnt == m) {
            for (int i = 0; i < m; i++) {
                bw.write(tmp[i] + " ");
            }
            bw.newLine();
        }

        for (int i = 0; i < n; i++) {
            if (!check[i]) {
                check[i] = true;
                tmp[cnt] = arr[i];
                dfs(tmp, check, cnt + 1);
                check[i] = false;
            }
        }
    }
}

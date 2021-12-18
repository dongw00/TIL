package backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Beak2529 {

    static int n;
    static long max = Long.MIN_VALUE, min = Long.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        char[] cond = new char[n];
        int[] arr = new int[10];
        boolean[] visited = new boolean[10];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            cond[i] = st.nextToken().charAt(0);
        }

        dfs(arr, cond, visited, 0);
        StringBuilder maxVal = new StringBuilder(String.valueOf(max));
        StringBuilder minVal = new StringBuilder(String.valueOf(min));

        if (maxVal.length() <= n) {
            maxVal.insert(0, "0");
        }

        if (minVal.length() <= n) {
            minVal.insert(0, "0");
        }

        System.out.println(maxVal);
        System.out.println(minVal);
    }

    public static void dfs(int[] arr, char[] cond, boolean[] visited, int cnt) {
        if (cnt == n + 1) {
            if (!isOrdered(arr, cond)) {
                return;
            }

            StringBuilder sb = new StringBuilder();
            for (int i = 0; i <= n; i++) {
                sb.append(arr[i]);
            }

            long val = Long.parseLong(sb.toString());
            if (max < val) {
                max = val;
            }

            if (min > val) {
                min = val;
            }
        }

        for (int i = 0; i < 10; i++) {
            if (!visited[i]) {
                visited[i] = true;
                arr[cnt] = i;
                dfs(arr, cond, visited, cnt + 1);
                visited[i] = false;
            }
        }
    }

    public static boolean isOrdered(int[] arr, char[] cond) {
        for (int i = 0; i < n; i++) {
            if ((cond[i] == '<' && arr[i] >= arr[i + 1]) || (cond[i] == '>' && arr[i] <= arr[i + 1])) {
                return false;
            }
        }
        return true;
    }
}

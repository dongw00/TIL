package backtracking;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Beak1759_2 {

    static int l, c;
    static char[] arr;
    static boolean[] visited;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        l = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        arr = new char[c];
        visited = new boolean[c];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < c; i++) {
            arr[i] = st.nextToken().charAt(0);
        }

        Arrays.sort(arr);
        dfs(0, 0);
    }

    public static void dfs(int idx, int start) {
        if (idx == l) {
            int v = 0;
            int cc = 0;

            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < c; i++) {
                if (visited[i]) {
                    sb.append(arr[i]);

                    if (arr[i] == 'a' || arr[i] == 'e' || arr[i] == 'i' || arr[i] == 'o' || arr[i] == 'u') {
                        v++;
                    } else {
                        cc++;
                    }
                }
            }

            if (cc >= 2 && v >= 1) {
                System.out.println(sb);
            }
        }

        for (int i = start; i < c; i++) {
            visited[i] = true;
            dfs(idx + 1, i + 1);
            visited[i] = false;
        }
    }
}

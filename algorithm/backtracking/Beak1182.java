package backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Beak1182 {

    static int cnt = 0;
    static int[] arr;
    static int N, S;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());

        arr = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        backtrack(0, 0);
        System.out.println(cnt);
    }

    private static void backtrack(int idx, int sum) {
        if (idx == N)
            return;

        if (sum + arr[idx] == S)
            cnt++;

        backtrack(idx + 1, sum);
        backtrack(idx + 1, sum + arr[idx]);
    }
}

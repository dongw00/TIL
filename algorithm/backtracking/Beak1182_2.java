package backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Beak1182_2 {

    static int[] arr;
    static int N, S;
    static int cnt = 0;

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

        backTrack(0, 0);
        System.out.println(cnt);
    }

    public static void backTrack(int idx, int sum) {
        if (idx == N) {
            return;
        }

        if (sum + arr[idx] == S) {
            cnt++;
        }

        backTrack(idx + 1, sum);
        backTrack(idx + 1, sum + arr[idx]);
    }

}

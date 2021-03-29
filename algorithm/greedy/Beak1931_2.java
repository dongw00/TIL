package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Beak1931_2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[][] arr = new int[N][2];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr, (a, b) -> {
            if (a[1] == b[1])
                return Integer.compare(a[0], b[0]);
            return Integer.compare(a[1], b[1]);
        });

        int cnt = 1;
        int tmp = arr[0][1];
        for (int i = 1; i < N; i++) {
            if (arr[i][0] >= tmp) {
                cnt++;
                tmp = arr[i][1];
            }
        }

        System.out.println(cnt);
    }
}

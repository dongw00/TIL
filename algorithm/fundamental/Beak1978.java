package fundamental;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Beak1978 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        int max = 0;
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            max = Math.max(arr[i], max);
        }

        boolean[] check = new boolean[max + 1];

        check[0] = check[1] = true;

        for (int i = 2; i * i <= max; i++) {
            for (int j = i * i; j <= max; j += i) {
                check[j] = true;
            }
        }

        int cnt = 0;
        for (int a : arr) {
            if (!check[a]) {
                cnt++;
            }
        }
        System.out.println(cnt);
    }
}

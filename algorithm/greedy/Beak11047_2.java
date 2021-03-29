package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Beak11047_2 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        int cnt = 0;
        for (int i = arr.length - 1; i >= 0; i--) {
            if (k == 0)
                break;
            if (k < arr[i])
                continue;
            cnt += k / arr[i];
            k %= arr[i];
        }
        System.out.println(cnt);
    }
}

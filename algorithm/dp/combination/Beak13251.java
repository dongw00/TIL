package dp.combination;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Beak13251 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int m = Integer.parseInt(br.readLine());
        int[] arr = new int[m];

        StringTokenizer st = new StringTokenizer(br.readLine());
        int total = 0;
        for (int i = 0; i < m; i++) {
            total += arr[i] = Integer.parseInt(st.nextToken());
        }

        int k = Integer.parseInt(br.readLine());

        double ans = 0;
        double[] probability = new double[m];

        for (int i = 0; i < m; i++) {
            if (arr[i] >= k) {
                probability[i] = 1.0;
                for (int j = 0; j < k; j++) {
                    probability[i] *= (arr[i] - j) / (double) (total - j);
                }
            }
            ans += probability[i];
        }

        System.out.println(ans);
    }
}

package samsung;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Beak13458 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        int boss = Integer.parseInt(st.nextToken());
        int subBoss = Integer.parseInt(st.nextToken());

        long cnt = 0;
        for (int i = 0; i < n; i++) {
            int tmp = arr[i] - boss;

            if (tmp <= 0) {
                cnt++;
            } else {
                cnt += (Math.ceil(tmp / (float) subBoss) + 1);
            }
        }

        System.out.println(cnt);
    }

}

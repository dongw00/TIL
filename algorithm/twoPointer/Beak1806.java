package twoPointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Beak1806 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int s = 0, e = 0;
        int sum = 0, min = Integer.MAX_VALUE;
        
        while (true) {
            if (sum >= S) {
                min = Math.min(min, e - s);
                sum -= arr[s++];
            } else if (e == N) {
                break;
            } else {
                sum += arr[e++];
            }
        }

        System.out.println(min != Integer.MAX_VALUE ? min : 0);
    }
}

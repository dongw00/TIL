package twoPointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Beak2230 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr);

        int start = 0, end = 0;
        int min = Integer.MAX_VALUE;

        while (start < N && end < N) {
            if (arr[end] - arr[start] >= M) {
                min = Math.min(min, arr[end] - arr[start++]);
            } else {
                end++;
            }
        }

        System.out.println(min != Integer.MAX_VALUE ? min : 0);
    }
}

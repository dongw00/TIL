package twoPointer;

import java.io.*;
import java.util.*;

public class Beak2531 {
    // 슬라이딩 윈도우
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        int[] arr = new int[n];
        int[] visited = new int[d + 1];

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        int ans = 0, max = 0;

        for (int i = 0; i < k; i++) {
            if (visited[arr[i]] == 0)
                ans++;

            visited[arr[i]]++;
        }

        max = ans;

        for (int i = 1; i < n; i++) {
            int postIdx = (i + k - 1) % n;
            visited[arr[postIdx]]++;
            visited[arr[i - 1]]--;

            int tmp = 0;
            for (int b : visited) {
                if (b > 0)
                    tmp++;
            }

            max = Math.max(max, tmp + (visited[c] == 0 ? 1 : 0));
        }

        System.out.println(max);
    }
}

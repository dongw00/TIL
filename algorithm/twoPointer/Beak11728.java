package twoPointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Beak11728 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] a = new int[n];
        int[] b = new int[m];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            b[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(a);
        Arrays.sort(b);

        int[] ans = new int[n + m];

        int aIdx = 0, bIdx = 0, idx = 0;

        while (aIdx < n && bIdx < m) {
            if (a[aIdx] < b[bIdx]) {
                ans[idx++] = a[aIdx++];
            } else {
                ans[idx++] = b[bIdx++];
            }
        }

        for (int i = aIdx; i < n; i++) {
            ans[idx++] = a[i];
        }

        for (int i = bIdx; i < m; i++) {
            ans[idx++] = b[i];
        }

        StringBuilder sb = new StringBuilder();
        for (int el : ans) {
            sb.append(el);
            sb.append(" ");
        }

        System.out.println(sb);
    }
}

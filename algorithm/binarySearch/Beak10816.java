package binarySearch;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Beak10816 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());


        StringTokenizer st = new StringTokenizer(br.readLine());
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int el = Integer.parseInt(st.nextToken());
            map.put(el, map.getOrDefault(el, 0) + 1);
        }

        int m = Integer.parseInt(br.readLine());
        int[] arr = new int[m];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < m; i++) {
            int cnt = map.getOrDefault(arr[i], 0);
            sb.append(cnt);
            if (i != n - 1) {
                sb.append(" ");
            }
        }

        System.out.println(sb);
    }
}

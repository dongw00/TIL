package graph.unionFind;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Beak1976 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        int[] arr = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            arr[i] = i;
        }

        for (int i = 1; i <= n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= n; j++) {
                int num = Integer.parseInt(st.nextToken());
                if (num == 1) {
                    unionParent(arr, i, j);
                }
            }
        }

        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] path = new int[m];
        for (int i = 0; i < m; i++) {
            path[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 1; i < m; i++) {
            if (!findParent(arr, path[i - 1], path[i])) {
                System.out.println("NO");
                return;
            }
        }
        System.out.println("YES");
    }

    private static int getParent(int[] arr, int x) {
        if (arr[x] == x) {
            return x;
        }

        return arr[x] = getParent(arr, arr[x]);
    }

    private static void unionParent(int[] arr, int a, int b) {
        a = getParent(arr, a);
        b = getParent(arr, b);

        if (a < b) {
            arr[b] = a;
        } else {
            arr[a] = b;
        }
    }

    private static boolean findParent(int[] arr, int a, int b) {
        a = getParent(arr, a);
        b = getParent(arr, b);

        return a == b;
    }
}

package graph.dfs;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Beak2023 {

    static int n;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        int[] arr = new int[]{2, 3, 5, 7};
        for (int j : arr) {
            dfs(j, 1);
        }
    }

    private static void dfs(int num, int idx) {
        if (idx == n) {
            if (isPrime(num)) {
                System.out.println(num);
            }
            return;
        }

        for (int i = 1; i < 10; i++) {
            if (isPrime(num * 10 + i)) {
                dfs(num * 10 + i, idx + 1);
            }
        }
    }

    private static boolean isPrime(int num) {
        if (num == 1) {
            return false;
        } else if (num == 2) {
            return true;
        } else if (num % 2 == 0) {
            return false;
        }

        for (int i = 3; i <= Math.sqrt(num); i += 2) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }
}

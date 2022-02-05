package twoPointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Beak1644 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        List<Integer> list = isPrime(n);

        int start = 0, end = 0;
        int sum = 0;

        int ans = 0;
        while (true) {
            if (sum >= n) {
                sum -= list.get(start++);
            } else if (end == list.size()) {
                break;
            } else {
                sum += list.get(end++);
            }

            if (sum == n) {
                ans++;
            }
        }

        System.out.println(ans);
    }

    public static List<Integer> isPrime(int n) {
        boolean[] chk = new boolean[n + 1];
        chk[0] = chk[1] = true;

        List<Integer> set = new ArrayList<>();
        for (int i = 2; i * i <= n; i++) {
            if (chk[i]) {
                continue;
            }

            for (int j = i * i; j <= n; j += i) {
                chk[j] = true;
            }
        }

        for (int i = 2; i <= n; i++) {
            if (!chk[i]) {
                set.add(i);
            }
        }
        return set;
    }

}

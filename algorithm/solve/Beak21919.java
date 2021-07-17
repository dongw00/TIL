package solve;

import java.io.*;
import java.util.*;

public class Beak21919 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());

        long ans = 1;

        for (int i = 0; i < n; i++) {
            long x = Long.parseLong(st.nextToken());
            if (isPrime(x)) {
                ans = lcm(ans, x);
            }
        }

        System.out.println(ans == 1 ? -1 : ans);
    }

    public static boolean isPrime(long x) {
        for (long i = 2; i * i <= x; i++) {
            if (x % i == 0)
                return false;
        }
        return true;
    }

    public static long gcd(long a, long b) {
        if (b == 0)
            return a;
        return gcd(b, a % b);
    }

    public static long lcm(long a, long b) {
        return a / gcd(a, b) * b;
    }
}

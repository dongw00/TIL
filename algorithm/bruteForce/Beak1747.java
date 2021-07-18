package bruteForce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Beak1747 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        while (true) {
            if (n <= 1) {
                System.out.println(2);
                break;
            }
            if (isPrime(n) && isPalindrome(n)) {
                System.out.println(n);
                break;
            }
            n++;
        }
    }

    public static boolean isPalindrome(int n) {
        String origin = String.valueOf(n);
        String reverse = new StringBuilder().append(n).reverse().toString();

        return origin.equals(reverse);
    }

    public static boolean isPrime(int n) {
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0)
                return false;
        }
        return true;
    }
}

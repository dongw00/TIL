package stringProblem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Beak10610 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s = br.readLine();
        System.out.println(solve(s));
    }

    public static String solve(String s) {
        if (s.indexOf('0') < 0 || !test(s)) {
            return "-1";
        }

        char[] charArr = s.toCharArray();
        Arrays.sort(charArr);

        String str = new String(charArr);
        str = new StringBuilder(str).reverse().toString();
        return str;
    }

    public static boolean test(String str) {
        long cnt = 0L;
        for (int i = 0; i < str.length(); i++) {
            int num = Integer.parseInt(str.substring(i, i + 1));
            cnt += num;
        }

        return cnt % 3 == 0;
    }
}

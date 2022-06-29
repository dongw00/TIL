package greedy;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Beak1541 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split("-");

        int ans = 0;
        for (int i = 0; i < str.length; i++) {
            int tmp = calc(str[i]);
            if (i == 0) {
                ans += tmp;
            } else {
                ans -= tmp;
            }
        }
        System.out.println(ans);
    }

    private static int calc(String str) {
        String[] tmp = str.split("[+]");

        int sum = 0;
        for (String t : tmp) {
            sum += Integer.parseInt(t);
        }
        return sum;
    }

}

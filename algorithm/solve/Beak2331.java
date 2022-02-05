package solve;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Beak2331 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int a = Integer.parseInt(st.nextToken());
        int p = Integer.parseInt(st.nextToken());

        Map<Long, Integer> map = new HashMap<>();

        long prev = a;
        while (map.getOrDefault(prev, 0) != 2) {
            map.put(prev, map.getOrDefault(prev, 0) + 1);
            prev = calc(prev, p);
        }

        int ans = 0;
        for (Map.Entry<Long, Integer> el : map.entrySet()) {
            if (el.getValue() == 1) {
                ans++;
            }
        }

        System.out.println(ans);
    }

    public static long calc(long prev, int p) {
        long sum = 0;
        while (prev != 0) {
            sum += (long) Math.pow((prev % 10), p);
            prev /= 10;
        }
        return sum;
    }
}

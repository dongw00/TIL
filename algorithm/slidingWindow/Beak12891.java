package slidingWindow;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Beak12891 {

    static int ans;
    static Map<Character, Integer> map;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int s = Integer.parseInt(st.nextToken());
        int p = Integer.parseInt(st.nextToken());

        String str = br.readLine();

        map = new HashMap<>();
        st = new StringTokenizer(br.readLine());

        map.put('A', -Integer.parseInt(st.nextToken()));
        map.put('C', -Integer.parseInt(st.nextToken()));
        map.put('G', -Integer.parseInt(st.nextToken()));
        map.put('T', -Integer.parseInt(st.nextToken()));

        for (int i = 0; i < p; i++) {
            map.compute(str.charAt(i), (k, v) -> v + 1);
        }

        int l = 0, r = p;

        ans = 0;

        while (true) {
            check();

            if (r >= s) {
                break;
            }

            map.compute(str.charAt(l), (k, v) -> v - 1);
            map.compute(str.charAt(r), (k, v) -> v + 1);
            l++;
            r++;
        }

        System.out.println(ans);
    }

    private static void check() {
        for (int val : map.values()) {
            if (val < 0) {
                return;
            }
        }

        ans++;
    }
}
package graph.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Beak16953 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long a = Long.parseLong(st.nextToken());
        long b = Long.parseLong(st.nextToken());

        int ans = 1;

        while (b != a) {
            if (b < a) {
                ans = -1;
                break;
            }

            String str = String.valueOf(b);

            if (str.charAt(str.length() - 1) != '1' && b % 2 != 0) {
                ans = -1;
                break;
            }

            if (b % 2 == 0) {
                b /= 2;
            } else {
                str = str.substring(0, str.length() - 1);
                b = Long.parseLong(str);
            }

            ans++;
        }

        System.out.println(ans);
    }
}

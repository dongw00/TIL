package bitmasking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Beak11723 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int m = Integer.parseInt(br.readLine());
        int bit = 0;

        StringBuilder sb = new StringBuilder();
        while (m-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String op = st.nextToken();

            int num =
                !op.equals("all") && !op.equals("empty") ? Integer.parseInt(st.nextToken()) : 0;

            switch (op) {
                case "add":
                    bit |= (1 << (num - 1));
                    break;
                case "remove":
                    bit &= ~(1 << (num - 1));
                    break;
                case "check":
                    sb.append((bit & (1 << num - 1)) != 0 ? "1\n" : "0\n");
                    break;
                case "toggle":
                    bit ^= (1 << (num - 1));
                    break;
                case "all":
                    bit |= (~0);
                    break;
                case "empty":
                    bit &= 0;
                    break;
            }
        }

        System.out.println(sb);
    }
}

package solve;

import java.io.*;
import java.util.*;

public class Beak21918 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] status = new int[n + 1];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++)
            status[i] = Integer.parseInt(st.nextToken());

        while (m-- > 0) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            switch (a) {
                case 1:
                    status[b] = c;
                    break;
                case 2:
                    for (int i = b; i <= c; i++) {
                        status[i] = status[i] == 0 ? 1 : 0;
                    }
                    break;
                case 3:
                    for (int i = b; i <= c; i++) {
                        status[i] = 0;
                    }
                    break;
                case 4:
                    for (int i = b; i <= c; i++) {
                        status[i] = 1;
                    }
                    break;
            }
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 1; i < status.length; i++) {
            sb.append(status[i]);

            if (i != status.length - 1) {
                sb.append(" ");
            }
        }

        System.out.println(sb);
    }
}

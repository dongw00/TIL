package samsung;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Beak14891 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] gears = new String[5];
        String[] nGears = new String[5];

        for (int i = 1; i <= 4; i++) {
            gears[i] = br.readLine();
        }

        int k = Integer.parseInt(br.readLine());
        for (int i = 0; i < k; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());
            int dir = Integer.parseInt(st.nextToken());

            int left = num - 1 < 1 ? 0 : num - 1;
            int right = num + 1 > 4 ? 5 : num + 1;

            // left gears
            int leftDir = dir;
            for (int j = left; j > 0; j--) {
                char cur = gears[j].charAt(2);
                char other = gears[j + 1].charAt(6);

                if (cur == other) {
                    break;
                }

                leftDir *= -1;

                nGears[j] = rotate(gears[j], leftDir);
            }

            // right gears
            int rightDir = dir;
            for (int j = right; j <= 4; j++) {
                char cur = gears[j].charAt(6);
                char other = gears[j - 1].charAt(2);

                if (cur == other) {
                    break;
                }

                rightDir *= -1;

                nGears[j] = rotate(gears[j], rightDir);
            }

            nGears[num] = rotate(gears[num], dir);

            for (int j = 1; j <= 4; j++) {
                if (nGears[j] != null) {
                    gears[j] = nGears[j];
                }
            }
        }

        int cnt = 0;
        for (int i = 1; i <= 4; i++) {
            if (gears[i].charAt(0) == '1') {
                switch (i) {
                    case 1:
                        cnt++;
                        break;
                    case 2:
                        cnt += 2;
                        break;
                    case 3:
                        cnt += 4;
                        break;
                    case 4:
                        cnt += 8;
                        break;
                }
            }
        }

        System.out.println(cnt);
    }

    public static String rotate(String num, int dir) {
        return dir == 1 ? clock(num) : rclock(num);
    }

    public static String clock(String num) {
        return num.charAt(7) + num.substring(0, num.length() - 1);
    }

    public static String rclock(String num) {
        return num.substring(1) + num.charAt(0);
    }
}

package twoPointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Beak1484 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int G = Integer.parseInt(br.readLine());

        int start = 1, end = 1;
        boolean check = false;

        while (true) {
            int val = end * end - start * start;
            if (val == G) {
                check = true;
                System.out.println(end);
            }

            if (val > G) {
                if (end - start == 1)
                    break;
                start++;
            } else {
                end++;
            }
        }

        if (!check)
            System.out.println(-1);
    }
}

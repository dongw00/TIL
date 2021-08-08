package bitmasking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Beak1094 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int WOOD = 64, cnt = 0;

        while (n > 0) {
            if (WOOD > n) {
                WOOD /= 2;
            } else {
                cnt++;
                n -= WOOD;
            }
        }

        System.out.println(cnt);
    }
}

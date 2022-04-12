package codeChallenge1;

import java.util.Arrays;

public class Pro70129 {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution("110010101001")));
        System.out.println(Arrays.toString(solution("01110")));
        System.out.println(Arrays.toString(solution("1111111")));
    }

    public static int[] solution(String s) {
        int zero = 0, cnt = 0;

        while (true) {
            if (s.equals("1")) {
                return new int[]{cnt, zero};
            }

            zero += s.length();

            s = s.replaceAll("0", "");

            zero -= s.length();

            int tmp = s.length();
            s = Integer.toBinaryString(tmp);
            cnt++;
        }
    }
}

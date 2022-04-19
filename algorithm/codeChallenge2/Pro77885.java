package codeChallenge2;

import java.util.Arrays;

public class Pro77885 {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(new long[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10})));
    }

    public static long[] solution(long[] numbers) {
        int size = numbers.length;

        long[] ans = new long[size];

        for (int i = 0; i < size; i++) {
            long num = numbers[i];

            if (num % 2 == 0) {
                ans[i] = num + 1;
                continue;
            }

            String binary = Long.toBinaryString(num);
            int lastIdx = binary.lastIndexOf("0");
            int firstIdx = binary.indexOf("1", lastIdx);

            if (lastIdx == -1) {
                binary = Long.toBinaryString(++num);
                binary = binary.substring(0, 2) + binary.substring(2).replace("0", "1");
            } else {
                binary = binary.substring(0, lastIdx) + "1" +
                        binary.substring(lastIdx + 1, firstIdx) + "0" +
                        binary.substring(firstIdx + 1);
            }

            ans[i] = Long.parseLong(binary, 2);
        }

        return ans;
    }
}

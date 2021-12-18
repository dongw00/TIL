package stringProblem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Beak1439 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s = br.readLine();
        int[] arr = new int[2];

        char prev = s.charAt(0);
        plusOne(arr, prev);
        for (int i = 1; i < s.length(); i++) {
            char cur = s.charAt(i);
            if (prev == cur) {
                continue;
            }

            plusOne(arr, cur);
            prev = cur;
        }

        Arrays.sort(arr);
        System.out.println(arr[0]);
    }

    public static void plusOne(int[] arr, char c) {
        if (c == '0') {
            arr[0]++;
        } else {
            arr[1]++;
        }
    }

}

package startupCodingFestival;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class scf_02 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[][] arr = new int[n][2];

        for (int i = 0; i < n; i++) {
            String[] str = br.readLine().split(" ~ ");
            for (int j = 0; j < str.length; j++) {
                String[] tmp = str[j].split(":");
                arr[i][j] = Integer.parseInt(tmp[0]) * 60 + Integer.parseInt(tmp[1]);
            }
        }

        int startTime = Integer.MIN_VALUE, endTime = Integer.MAX_VALUE;
        for (int[] el : arr) {
            startTime = Math.max(startTime, el[0]);
            endTime = Math.min(endTime, el[1]);
        }

        if (startTime >= endTime) {
            System.out.println(-1);
        } else {
            System.out.println(
                convertNum(startTime / 60) + ":" + convertNum(startTime % 60) + " ~ " + convertNum(
                    endTime / 60) + ":" + convertNum(endTime % 60));
        }
    }

    private static String convertNum(int time) {
        return time < 10 ? "0" + time : String.valueOf(time);
    }
}

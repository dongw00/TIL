package twoPointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Beak2096 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] tmpMax = new int[3];
        int[] tmpMin = new int[3];

        int[] colMax = new int[3];
        int[] colMin = new int[3];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            for (int j = 0; j < 3; j++) {
                tmpMin[j] = tmpMax[j] = Integer.parseInt(st.nextToken());

                if (j == 0) {
                    tmpMax[j] += Math.max(colMax[0], colMax[1]);
                    tmpMin[j] += Math.max(colMin[0], colMin[1]);
                } else if (j == 1) {
                    tmpMax[j] += Math.max(colMax[0], Math.max(colMax[1], colMax[2]));
                    tmpMin[j] += Math.max(colMin[0], Math.max(colMin[1], colMin[2]));
                } else {
                    tmpMax[j] += Math.max(colMax[1], colMax[2]);
                    tmpMin[j] += Math.min(colMin[1], colMin[2]);
                }
            }

            colMax = Arrays.copyOfRange(tmpMax, 0, 3);
            colMin = Arrays.copyOfRange(tmpMin, 0, 3);
        }

        Arrays.sort(colMax);
        Arrays.sort(colMin);

        System.out.println(colMax[2] + " " + colMin[0]);
    }

}

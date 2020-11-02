package slidingWindow;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Beak2096 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[] colMax = new int[3];
        int[] colMin = new int[3];

        int[] tempMax = new int[3];
        int[] tempMin = new int[3];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) {
                tempMin[j] = tempMax[j] = Integer.parseInt(st.nextToken());
                if (j == 0) {
                    tempMax[j] += Math.max(colMax[0], colMax[1]);
                    tempMin[j] += Math.min(colMin[0], colMin[1]);
                } else if (j == 1) {
                    tempMax[j] += Math.max(colMax[0], Math.max(colMax[1], colMax[2]));
                    tempMin[j] += Math.min(colMin[0], Math.min(colMin[1], colMin[2]));
                } else {
                    tempMax[j] += Math.max(colMax[1], colMax[2]);
                    tempMin[j] += Math.min(colMin[1], colMin[2]);
                }
            }
            colMax = Arrays.copyOfRange(tempMax, 0, 3);
            colMin = Arrays.copyOfRange(tempMin, 0, 3);
        }

        Arrays.sort(colMax);
        Arrays.sort(colMin);
        System.out.println(colMax[2] + " " + colMin[0]);
    }
}

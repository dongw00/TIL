package startupCodingFestival;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class scf_01 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[][] arr = new int[n][n];

        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            for (int j = 0; j < n; j++) {
                arr[i][j] = str.charAt(j) - '0';
            }
        }

        int[] ans = new int[51];
        int total = 0;

        for (int size = 0; size < n; size++) {
            int cnt = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    try {
                        if (arr[i][j] == 1 && arr[i][j + size] == 1 && arr[i + size][j] == 1
                            && arr[i + size][j + size] == 1) {
                            cnt++;
                        }
                    } catch (Exception e) {
                    }
                }
            }

            ans[size] = cnt;
            total += cnt;
        }

        System.out.println("total: " + total);
        for (int i = 0; i < n; i++) {
            if (ans[i] > 0) {
                System.out.println("size[" + (i + 1) + "]: " + ans[i]);
            }
        }
    }
}

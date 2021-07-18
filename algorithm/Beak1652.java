import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Beak1652 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        boolean[][] arr = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            for (int j = 0; j < n; j++) {
                arr[i][j] = str.charAt(j) == '.';
            }
        }

        int row = 0;
        int col = 0;
        for (int i = 0; i < n; i++) {
            int rowCnt = 0;
            int colCnt = 0;

            for (int j = 0; j < n; j++) {
                // row
                if (arr[i][j]) {
                    rowCnt++;
                } else if (!arr[i][j]) {
                    if (rowCnt >= 2) {
                        row++;
                    }
                    rowCnt = 0;
                }

                // col
                if (arr[j][i]) {
                    colCnt++;
                } else if (!arr[j][i]) {
                    if (colCnt >= 2) {
                        col++;
                    }
                    colCnt = 0;
                }
            }

            if (rowCnt >= 2) {
                row++;
            }

            if (colCnt >= 2) {
                col++;
            }
        }

        System.out.println(row + " " + col);
    }
}

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
 
public class Beak2448 {
    private static char[][] map;
 
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine().trim());
        
        map = new char[n][2 * n - 1];
        for (int i = 0; i<n; i++)
            for (int j = 0; j < 2*n-1; j++)
                map[i][j] = ' ';
        
        drawStar(0, n-1, n);
        
        for (int i = 0; i<n; i++) {
            for (int j = 0; j < 2*n-1; j++)
            	bw.write(map[i][j]);
            bw.write('\n');
        }
        bw.flush();
        bw.close();
    }
 
    private static void drawStar(int x, int y, int n) {
        if (n == 3) {
            map[x][y] = '*';
            map[x + 1][y - 1] = map[x + 1][y + 1] = '*';
            map[x + 2][y - 2] = map[x + 2][y - 1] = map[x + 2][y] = map[x + 2][y + 1] = map[x + 2][y + 2] = '*';
            return;
        }
 
        drawStar(x, y, n / 2);
        drawStar(x + n / 2, y - n / 2, n / 2);
        drawStar(x + n / 2, y + n / 2, n / 2);
    }
}
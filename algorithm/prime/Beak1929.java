package prime;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Beak1929 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        boolean[] prime = new boolean[n + 1];
        eratos(prime);

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for (int i = m; i <= n; i++) {
            if (!prime[i]) {
                bw.write(i + "\n");
            }
        }
        bw.flush();
        bw.close();
    }

    private static void eratos(boolean[] prime) {
        prime[0] = prime[1] = true;

        for (int i = 2; i * i < prime.length; i++) {
            if (!prime[i]) {
                for (int j = i * i; j < prime.length; j += i) {
                    prime[j] = true;
                }
            }
        }
    }

}

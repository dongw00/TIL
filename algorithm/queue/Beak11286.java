package queue;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;

public class Beak11286 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> {
            if (Math.abs(a) == Math.abs(b)) {
                return Integer.compare(a, b);
            }
            return Integer.compare(Math.abs(a), Math.abs(b));
        });

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        while (n-- > 0) {
            int x = Integer.parseInt(br.readLine());

            if (x == 0) {
                bw.write((!pq.isEmpty() ? pq.remove() : 0) + "\n");
                continue;
            }
            pq.add(x);
        }

        bw.flush();
        bw.close();
    }
}

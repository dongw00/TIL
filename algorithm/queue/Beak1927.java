package queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Beak1927 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> queue = new PriorityQueue<>();

        for (int i = 0; i < N; i++) {
            int t = Integer.parseInt(br.readLine());
            if (t == 0) {
                if (!queue.isEmpty()) {
                    System.out.println(queue.remove());
                } else {
                    System.out.println(0);
                }
            } else {
                queue.add(t);
            }
        }
    }
}

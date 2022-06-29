package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Beak1715 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int el : arr) {
            pq.add(el);
        }

        int tmp1, tmp2;
        int sum = 0;
        while (pq.size() != 1) {
            tmp1 = pq.remove();
            tmp2 = pq.remove();

            sum += (tmp1 + tmp2);
            pq.add(tmp1 + tmp2);
        }

        System.out.println(sum);
    }
}

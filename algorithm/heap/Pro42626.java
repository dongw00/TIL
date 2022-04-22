package heap;

import java.util.PriorityQueue;

public class Pro42626 {

    public static void main(String[] args) {
        Pro42626 p = new Pro42626();
        System.out.println(p.solution(new int[]{1, 2, 3, 9, 10, 12}, 7));
    }

    public int solution(int[] arr, int K) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int j : arr) {
            pq.add(j);
        }

        try {
            int cnt = 0;
            while (!pq.isEmpty() && pq.peek() < K) {
                cnt++;
                int first = pq.remove();
                int second = pq.remove();

                pq.add(first + (second * 2));
            }
            return cnt;
        } catch (Exception e) {
            return -1;
        }
    }
}

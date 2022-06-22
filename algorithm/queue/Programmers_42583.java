package queue;

import java.util.LinkedList;
import java.util.Queue;

public class Programmers_42583 {

    public static void main(String[] args) {
        System.out.println(solution(2, 10, new int[]{7, 4, 5, 6}));
        System.out.println(solution(100, 100, new int[]{10}));
        System.out.println(solution(100, 100, new int[]{10, 10, 10, 10, 10, 10, 10, 10, 10, 10}));
    }

    public static int solution(int bridge_length, int weight, int[] truck_weights) {
        Queue<Integer> queue = new LinkedList<>();

        for (int i = 0; i < bridge_length; i++) {
            queue.add(0);
        }

        int idx = 0, sum = 0, time = 0;

        while (!queue.isEmpty()) {
            int tmp = queue.remove();
            sum -= tmp;

            if (idx < truck_weights.length) {
                if (sum + truck_weights[idx] <= weight) {
                    queue.add(truck_weights[idx]);
                    sum += truck_weights[idx++];
                } else {
                    queue.add(0);
                }
            }
            time++;
        }

        return time;
    }
}

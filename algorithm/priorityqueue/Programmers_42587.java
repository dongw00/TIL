package priorityqueue;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;

public class Programmers_42587 {
    public static void main(String[] args) {
        System.out.println(solution(new int[] {2, 1, 3, 2}, 2));
        System.out.println(solution(new int[] {1, 1, 9, 1, 1, 1}, 0));
    }

    public static int solution(int[] priorities, int location) {
        int ans = 1;

        Queue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        for (int priority : priorities) {
            pq.add(priority);
        }

        while (!pq.isEmpty()) {
            for (int i = 0; i < priorities.length; i++) {
                if (priorities[i] == pq.peek()) {
                    if (i == location)
                        return ans;
                    pq.remove();
                    ans++;
                }
            }
        }
        return ans;
    }
}

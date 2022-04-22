package heap;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Pro42627 {

    public static void main(String[] args) {
        Pro42627 p = new Pro42627();
        System.out.println(p.solution(new int[][]{{0, 3}, {1, 9}, {2, 6}}));
    }

    public int solution(int[][] jobs) {
        Arrays.sort(jobs, Comparator.comparingInt(o -> o[0]));

        PriorityQueue<int[]> queue = new PriorityQueue<>(Comparator.comparingInt(o -> o[1]));

        int cnt = 0;
        int jobsIdx = 0;
        int end = 0;
        int ans = 0;

        while (cnt < jobs.length) {
            while (jobsIdx < jobs.length && jobs[jobsIdx][0] <= end) {
                queue.add(jobs[jobsIdx++]);
            }

            if (queue.isEmpty()) {
                end = jobs[jobsIdx][0];
            } else {
                int[] tmp = queue.remove();
                ans += tmp[1] + end - tmp[0];
                end += tmp[1];
                cnt++;
            }
        }

        return (int) Math.floor(ans / (float) jobs.length);
    }
}

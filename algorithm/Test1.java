import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

class Test1 {

    public static void main(String[] args) throws Exception {
        int N = 3;
        int[] arr = {5, 2, 2, 5, 3};

        Queue<Coffee> queue = new PriorityQueue<>();

        int idx = 0;
        List<Integer> ans = new ArrayList<>();

        while (idx < arr.length || !queue.isEmpty()) {
            if (idx < arr.length && queue.size() < N) {
                queue.add(new Coffee(arr[idx], idx));
                idx++;
            } else {
                int time = 0;
                while (!queue.isEmpty()) {
                    Coffee c = queue.remove();
                    if (time == 0 || c.time <= time) {
                        time += c.time;
                        ans.add(c.idx + 1);
                    } else if (N == 1) {
                        ans.add(c.idx + 1);
                        break;
                    } else {
                        c.time -= time;
                        queue.add(c);
                        break;
                    }
                }
            }
        }

        for (int el : ans) {
            System.out.println(el);
        }
    }

    static class Coffee implements Comparable<Coffee> {
        int time;
        int idx;

        public Coffee(int time, int idx) {
            this.time = time;
            this.idx = idx;
        }

        @Override public int compareTo(Coffee o) {
            if (this.time > o.time)
                return 1;
            else if (this.time == o.time) {
                return Integer.compare(this.idx, o.idx);
            } else {
                return -1;
            }
        }
    }
}